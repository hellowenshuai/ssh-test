/**
 * 
 */
package com.fuji.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.fuji.bean.Material;
import com.fuji.common.PageBean;

/**
 * @author 860618058
 *
 */
public interface MaterialService {

	/**
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, int currentPage, int pageSize);

	/**
	 * @param bankIdSql
	 * @param material_type
	 * @param material_version
	 * @param remark
	 * @return
	 */
	int findMaterialListCount(String bankIdSql, String material_type,
			String material_version, String remark);

	/**
	 * @param bankIdSql
	 * @param material_type
	 * @param material_version
	 * @param remark
	 * @param startRow
	 * @param pageSize
	 * @return
	 */
	List findMaterialListShow(String bankIdSql, String material_type,
			String material_version, String remark, int startRow, int pageSize);

	/**
	 * 根据id获取素材数据
	 * @param id
	 * @return
	 */
	Material findMaterialById(Integer id);

	/**
	 * 修改旧的素材信息的数量为0，status+1，status>1 status !=3
	 * @param bank_id
	 * @param material_type
	 */
	void updateOldMaterial(String bank_id, String material_type);

	/**获取所有修改的当前素材类型的过去版本的素材
	 * @param bank_id 素材的银行Id
	 * @param material_type 素材类型
	 * @return 过去版本的素材
	 */
	List<Material> findOldMaterialsByTypeAndBankId(String bank_id, String material_type);

	/**
	 * 修改新的素材信息
	 * 	 * @param newMaterial
	 */
	void updateNewMaterial(Material newMaterial);

	List<Material> findOldMaterialsByTypeAndBankId3(String bank_id, String material_type);

	void removeOldMaterial(Material material);


}
