/**
 * 
 */
package com.fuji.bean;

/**
 * 素材展示需要的一些参数，vo
 * @author 860618058
 *
 */

public class MaterialListShow {
	
    /**
     * 银行ID
     */
    private String bank_Id;
    
    private Integer material_id;
    
    /** 银行名 */
    private String bank_name;
    
	/**
	 * 素材类型
	 */
	private String material_type;
	/**
	 * 素材版本
	 */
	private String material_version;
	/**
	 *备注 
	 */
	private String remark;
	/**
	 *发布状态 
	 */
	private Integer release_status;
	
	/**
	 *已部署机器数量 
	 */
	private Integer deploy_machine_num;
	/**
	 * 更新时间
	 */
	private String update_datetime;
	public String getMaterial_type() {
		return material_type;
	}
	public void setMaterial_type(String material_type) {
		this.material_type = material_type;
	}
	public String getMaterial_version() {
		return material_version;
	}
	public void setMaterial_version(String material_version) {
		this.material_version = material_version;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRelease_status() {
		return release_status;
	}
	public void setRelease_status(Integer release_status) {
		this.release_status = release_status;
	}
	public Integer getDeploy_machine_num() {
		return deploy_machine_num;
	}
	public void setDeploy_machine_num(Integer deploy_machine_num) {
		this.deploy_machine_num = deploy_machine_num;
	}
	public String getUpdate_datetime() {
		return update_datetime;
	}
	public void setUpdate_datetime(String update_datetime) {
		this.update_datetime = update_datetime;
	}
	public String getBank_Id() {
		return bank_Id;
	}
	public void setBank_Id(String bank_Id) {
		this.bank_Id = bank_Id;
	}
	public Integer getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	
	
	

}
