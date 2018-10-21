/**
 * 
 */
package com.fuji.action.material;

import com.fuji.action.BaseListAction;
import com.fuji.common.CommonUtil;
import com.fuji.common.Constants;
import com.fuji.common.PagerHelp;
import com.fuji.service.MaterialService;
import com.fuji.service.UserService;

/**
 * @author 860618058
 * 
 */
public class ListMaterialAction extends BaseListAction {

	private static final long serialVersionUID = 1L;
	/** 银行ID */
	public String bankId;
    /** 用户名 */
    public String userName;
	/** 素材类型 */
	public String material_type;
	/** 素材版本 */
	public String material_version;
	/** 素材备注 */
	public String remark;
	/** 银行ID 内部使用 */
	public String bankIdOrgin;
	/** 素材类型 内部使用 */
	public String materialTypeOrgin;
	/** 素材版本 内部使用 */
	public String materialVersionOrgin;
	/** 素材备注 内部使用 */
	public String remarkOrgin;
	/** 操作对象更新时间 */
	public String updateDatetimeOperation;
	/** 验证错误有无判定 */
	public boolean hassError = false;
	/** service */
	private MaterialService materialService;
	

//	 material_type;
//	 material_version;
//	 remark
//	bankIdOrgin
//	materialTypeOrgin
//	materialVersionOrgin
//	remarkOrgin
//	 bankId;
	public String init() throws Exception {

		if (!CommonUtil.isEmpty(bankIdOrgin)
				|| !CommonUtil.isEmpty(materialTypeOrgin)
				|| !CommonUtil.isEmpty(materialVersionOrgin)
				|| !CommonUtil.isEmpty(remarkOrgin)) {
			bankId = bankIdOrgin;
			material_type = materialTypeOrgin;
			material_version = materialTypeOrgin;
			remark = materialTypeOrgin;
		} else {
			// 用户权限取得
			String userPriority = getUserPriorityFromSession();

			// 检索条件_银行ID设置
			bankId = initBankIdForSearch(true);

			if (Constants.VALUE_PRIORITY_NORMAL.equals(userPriority)) {
				// 获取素材类型
				material_type=getMaterialTypeFromSession();
				// 获取素材版本
				material_version=getMaterial_version();
				// 获取素材备注
				remark = getRemarkFromSession();
			}
		}
		// 一览数据检索
		findData();

		return "list";
	}
	
	 /**
     * 一览表示处理
     */
    @Override
    public String execute() throws Exception {
    	
    	if(material_type!=null||!" ".equals(material_type)){
    		material_type = material_type.trim() ;
    	}
    	if(material_version!=null||!" ".equals(material_version)){
    		material_version = material_version.trim() ;
    	}
    	if(remark!=null||!" ".equals(remark)){
    		remark = remark.trim() ;
    	}

        // 一览数据检索
        findData();


        return "list";
    }
	
	/**
	 * 一览数据检索
	 * 
	 * @throws Exception
	 */
	private void findData() throws Exception {

		// SQL检索用银行ID
		String bankIdSql = CommonUtil.fixBankIdForSearch(bankId);

		// 一览总件数取得
		totalRows = materialService.findMaterialListCount(bankIdSql,material_type,material_version,remark);

		if (totalRows > 0) {
			// 分页信息作成
			pager = PagerHelp.getPager(currentPage, turnPageType, totalRows);
			currentPage = String.valueOf(pager.getCurrentPage());

			// 一览分页查询
			list = materialService.findMaterialListShow(bankIdSql, material_type,material_version,remark,
					pager.getStartRow(), pager.getPageSize());

		}

	}

	public String getMaterial_version() {
		return material_version;
	}

	public void setMaterial_version(String material_version) {
		this.material_version = material_version;
	}

	public String getMaterialTypeOrgin() {
		return materialTypeOrgin;
	}

	public void setMaterialTypeOrgin(String materialTypeOrgin) {
		this.materialTypeOrgin = materialTypeOrgin;
	}

	public String getMaterialVersionOrgin() {
		return materialVersionOrgin;
	}

	public void setMaterialVersionOrgin(String materialVersionOrgin) {
		this.materialVersionOrgin = materialVersionOrgin;
	}

	public String getRemarkOrgin() {
		return remarkOrgin;
	}

	public void setRemarkOrgin(String remarkOrgin) {
		this.remarkOrgin = remarkOrgin;
	}

	public MaterialService getMaterialService() {
		return materialService;
	}

	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
