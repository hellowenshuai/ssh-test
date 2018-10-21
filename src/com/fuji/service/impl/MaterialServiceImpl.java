/**
 * 
 */
package com.fuji.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.fuji.bean.Material;
import com.fuji.common.PageBean;
import com.fuji.dao.MaterialDao;
import com.fuji.service.MaterialService;

/**
 * @author 860618058
 *
 */
public class MaterialServiceImpl implements MaterialService {

	private MaterialDao materialDao;

	public MaterialDao getMaterialDao() {
		return materialDao;
	}

	public void setMaterialDao(MaterialDao materialDao) {
		this.materialDao = materialDao;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, int currentPage, int pageSize) {
		// 1.查询总记录数
		Integer totalCount = materialDao.getTotalCount(dc);
		// 2.创建pageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		// 3.查询分页列表数据
		List<Material> list = materialDao.getPageList(dc, pb.getStart(), pb.getPageSize());
		// 4.将列表数据放入到pageBean中
		pb.setList(list);
		return pb;
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
	 * @see
	 * com.fuji.service.MaterialService#findMaterialListCount(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int findMaterialListCount(String bankId, String material_type, String material_version, String remark) {
		return this.materialDao.findMaterialListCount(bankId, material_type, material_version, remark);
	}

	/*
	 * (非 Javadoc) <p>Title: findUserListShow</p> <p>Description: </p>
	 * 
	 * @param bankIdSql
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
	 * @see com.fuji.service.MaterialService#findUserListShow(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public List findMaterialListShow(String bankId, String material_type, String material_version, String remark,
			int startRow, int pageSize) {
		return this.materialDao.findMaterialListShow(bankId, material_type, material_version, remark, startRow,
				pageSize);
	}

	@Override
	public Material findMaterialById(Integer id) {
		return this.materialDao.findMaterialById(id);
	}

	@Override
	public void updateOldMaterial(String bank_id, String material_type) {
		this.materialDao.updateOldMaterial(bank_id, material_type);
	}

	@Override
	public List<Material> findOldMaterialsByTypeAndBankId(String bank_id, String material_type) {
		return this.materialDao.findOldMaterialsByTypeAndBankId(bank_id,material_type);
	}

	@Override
	public void updateNewMaterial(Material newMaterial) {
		Date update_datetime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd000000");
		newMaterial.setUpdate_datetime(sdf.format(update_datetime));
		this.materialDao.updateNewMaterial(newMaterial);
	}

	@Override
	public List<Material> findOldMaterialsByTypeAndBankId3(String bank_id, String material_type) {
		return this.materialDao.findOldMaterialsByTypeAndBankId3(bank_id,material_type);
	}

	@Override
	public void removeOldMaterial(Material material) {
		this.materialDao.deleteOldMaterial(material);
		
	}

}
