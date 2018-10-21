/**
 * 
 */
package com.fuji.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.fuji.bean.Material;

/**
 * @author 860618058
 *
 */
public interface MaterialDao {

	/**
	 * @param dc
	 * @return
	 */
	Integer getTotalCount(DetachedCriteria dc);

	/**
	 * @param dc
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Material> getPageList(DetachedCriteria dc, Integer start,
			Integer pageSize);
	
    void saveOrUpdate(Material t);

	/** 
	* @Title: findUserListCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param bankIdSql
	* @param @param material_type
	* @param @param material_version
	* @param @param remark
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws 
	*/
	
	int findMaterialListCount(String bankId, String material_type,
			String material_version, String remark);

	/** 
	* @Title: findUserListShow 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param bankId
	* @param @param material_type
	* @param @param material_version
	* @param @param remark
	* @param @param startRow
	* @param @param pageSize
	* @param @return    设定文件 
	* @return List    返回类型 
	* @throws 
	*/
	
	List findMaterialListShow(String bankId, String material_type,
			String material_version, String remark, int startRow, int pageSize);

	/**
	 * 根据id获取素材数据
	 * @param id 素材ID
	 * @return 当前素材
	 */
	Material findMaterialById(Integer id);


	/**
	 * 修改旧的素材信息的数量为0，status+1，status>1 status !=3
	 * @param bank_id
	 * @param material_type
	 */
	void updateOldMaterial(String bank_id, String material_type);

	/**
	 * 获取当前素材类型对应的所有的旧版本素材的数据
	 * @param bank_id
	 * @param material_type
	 * @return
	 */
	List<Material> findOldMaterialsByTypeAndBankId(String bank_id, String material_type);

	/**更新新的素材
	 * @param newMaterial
	 */
	void updateNewMaterial(Material newMaterial);

	List<Material> findOldMaterialsByTypeAndBankId3(String bank_id, String material_type);

	void deleteOldMaterial(Material material);

}
