/**
 * 
 */
package com.fuji.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fuji.bean.Bank;
import com.fuji.bean.Material;
import com.fuji.bean.MaterialListShow;
import com.fuji.common.CommonUtil;
import com.fuji.dao.MaterialDao;

/**
 * @author 860618058
 *
 */
public class MaterialDaoImpl extends HibernateDaoSupport implements MaterialDao {

	/** key_件数取得用sql */
	private static String KEY_SQL_COUNT = "sqlCount";
	/** key_一览取得用sql */
	private static String KEY_SQL_LIST = "sqlList";
	/** key_参数集 */
	private static String KEY_PARAMS = "params";

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		// 设置查询的聚合函数，查询总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		// 清空之前的聚合函数
		dc.setProjection(null);
		if (list != null && list.size() > 0) {
			Long count = list.get(0);
			return count.intValue();
		}
		return null;
	}

	@Override
	public List<Material> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		List<Material> list = (List<Material>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public void saveOrUpdate(Material t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	/**
	 * @Title: makeSqlForMaterialListShow @Description: @param @param
	 * bankId @param @param material_type @param @param
	 * material_version @param @param remark @param @return 设定文件 @return
	 * Map<String,Object> 返回类型 @throws
	 */

	private Map<String, Object> makeSqlForMaterialListShow(String bankId, String material_type, String material_version,
			String remark) {
		Map<String, Object> result = new Hashtable<String, Object>();
		boolean hasWhere = false;

		StringBuffer countSelect = new StringBuffer(" select count(*) as totalRows ");
		StringBuffer listSelect = new StringBuffer(" select bank.bank_name as bankName, {material.*}");

		StringBuffer sb = new StringBuffer(" from bank inner join material on (bank.bank_id = material.bank_id) ");

		ArrayList<String> params = new ArrayList<String>();

		if (!CommonUtil.isEmpty(bankId)) {
			sb.append(" where ");
			hasWhere = true;
			sb.append(" material.bank_id = ? ");
			params.add(bankId);
		}

		if (!CommonUtil.isEmpty(material_type)) {
			hasWhere = CommonUtil.appendWhereOrAndSqlMark(hasWhere, sb);
			sb.append(" material.material_type like ? ");
			params.add("%" + material_type + "%");
		}
		if (!CommonUtil.isEmpty(material_version)) {
			hasWhere = CommonUtil.appendWhereOrAndSqlMark(hasWhere, sb);
			sb.append(" material.material_version like ? ");
			params.add("%" + material_version + "%");
		}
		if (!CommonUtil.isEmpty(remark)) {
			hasWhere = CommonUtil.appendWhereOrAndSqlMark(hasWhere, sb);
			sb.append(" material.remark like ? ");
			params.add("%" + remark + "%");
		}

		String sqlCount = countSelect.append(sb).toString();
		String sqlList = listSelect.append(sb).toString();

		result.put(KEY_SQL_COUNT, sqlCount);
		result.put(KEY_SQL_LIST, sqlList);
		result.put(KEY_PARAMS, params);

		return result;
	}

	/*
	 * (非 Javadoc) <p>Title: findMaterialListCount</p> <p>Description: </p>
	 * 
	 * @param bankIdSql
	 * 
	 * @param material_type
	 * 
	 * @param material_version
	 * 
	 * @param remark
	 * 
	 * @return
	 * 
	 * @see com.fuji.dao.MaterialDao#findMaterialListCount(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int findMaterialListCount(String bankId, String material_type, String material_version, String remark) {
		int result = 0;

		// sql作成
		Map<String, Object> sqlMap = makeSqlForMaterialListShow(bankId, material_type, material_version, remark);
		String sql = (String) sqlMap.get(KEY_SQL_COUNT);
		List<String> params = (List<String>) sqlMap.get(KEY_PARAMS);

		Session session = this.getHibernateTemplate().getSessionFactory().openSession();

		SQLQuery query = session.createSQLQuery(sql).addScalar("totalRows", Hibernate.INTEGER);

		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}

		List list = query.list();

		session.close();

		// 查询结果转化到画面表示用的对象里
		if (!CommonUtil.isEmpty(list)) {

			result = ((Integer) list.get(0)).intValue();

		}

		return result;
	}

	/*
	 * (非 Javadoc) <p>Title: findMaterialListShow</p> <p>Description: </p>
	 * 
	 * @param bankId
	 * 
	 * @param material_type
	 * 
	 * @param material_version
	 * 
	 * @param remark
	 * 
	 * @param startRow
	 * 
	 * @param pageSize
	 * 
	 * @return
	 * 
	 * @see com.fuji.dao.MaterialDao#findMaterialListShow(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public List findMaterialListShow(String bankId, String material_type, String material_version, String remark,
			int startRow, int pageSize) {
		List<MaterialListShow> resultList = new ArrayList<MaterialListShow>();

		// sql作成
		Map<String, Object> sqlMap = makeSqlForMaterialListShow(bankId, material_type, material_version, remark);
		String sql = (String) sqlMap.get(KEY_SQL_LIST);
		List<String> params = (List<String>) sqlMap.get(KEY_PARAMS);

		Session session = this.getHibernateTemplate().getSessionFactory().openSession();

		SQLQuery query = session.createSQLQuery(sql).addScalar("bankName", Hibernate.STRING).addEntity("material",
				Material.class);

		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);

		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}

		List list = query.list();

		session.close();

		// 查询结果转化到画面表示用的对象里
		if (!CommonUtil.isEmpty(list)) {

			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				MaterialListShow show = new MaterialListShow();
				String bankName = (String) (obj[0]);
				Material material = (Material) (obj[1]);
				show.setBank_name(bankName);
				show.setMaterial_id(material.getId());
				show.setMaterial_type(material.getMaterial_type());
				show.setMaterial_version(material.getMaterial_version());
				show.setRemark(material.getRemark());
				show.setRelease_status(material.getRelease_status());//
				show.setDeploy_machine_num(material.getDeploy_machine_num());

				show.setBank_Id(material.getBankId());
				show.setMaterial_id(material.getId());
				show.setUpdate_datetime(material.getUpdate_datetime());
				resultList.add(show);
			}

		}
		return resultList;
	}

	@Override
	public Material findMaterialById(Integer id) {
		Material material = (Material) this.getHibernateTemplate().get(Material.class, id);
		return material;
	}

	@Override
	public void updateOldMaterial(String bank_id, String material_type) {
		
	}

	@Override
	public List<Material> findOldMaterialsByTypeAndBankId(String bank_id, String material_type) {
		String hql = "from Material material where material.bank_id = ? and material.material_type = ? and material.release_status = ?";
		return (List<Material>)this.getHibernateTemplate().find(hql,new Object[]{bank_id,material_type,2});
	}

	@Override
	public void updateNewMaterial(Material newMaterial) {
		this.getHibernateTemplate().update(newMaterial);		
	}

	@Override
	public List<Material> findOldMaterialsByTypeAndBankId3(String bank_id, String material_type) {
		String hql = "from Material material where material.bank_id = ? and material.material_type = ? and material.release_status = ?";
		return (List<Material>)this.getHibernateTemplate().find(hql,new Object[]{bank_id,material_type,3});
	}

	@Override
	public void deleteOldMaterial(Material material) {
		this.getHibernateTemplate().delete(material);
	}


}
