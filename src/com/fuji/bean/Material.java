/**
 * 
 */
package com.fuji.bean;

import java.io.Serializable;

/**
 * 素材表
 * @author 860618058
 *
 */
public class Material implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private Integer id;
	private String bank_id;
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
	 * 插入时间
	 */
	private String insert_datetime;
	/**
	 * 插入者名
	 */
	private String insert_user_name;
	/**
	 * 更新时间
	 */
	private String update_datetime;
	/**
	 * 更新者名
	 */
	private String update_user_name;
	
	/**
	 * 银行ID 外键 多对一关系
	 */
	private Bank bank;
	
	/**
	 * 获取表单传来的数据
	 */
	private String bankId;
	
	

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * 获取银行表
	 * @return
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * 设置银行表
	 * @param bank
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	/**获取素材ID
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置素材ID
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取素材类型
	 * @return
	 */
	public String getMaterial_type() {
		return material_type;
	}

	/**
	 * 设置素材类型
	 * @param material_type
	 */
	public void setMaterial_type(String material_type) {
		this.material_type = material_type;
	}

	/**
	 * 获取素材版本
	 * @return
	 */
	public String getMaterial_version() {
		return material_version;
	}

	/**
	 * 设置素材版本
	 * @param material_version
	 */
	public void setMaterial_version(String material_version) {
		this.material_version = material_version;
	}

	/**
	 * 获取备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取发布状态
	 * @return
	 */
	public Integer getRelease_status() {
		return release_status;
	}

	/**
	 * 设置发布状态
	 * @param release_status
	 */
	public void setRelease_status(Integer release_status) {
		this.release_status = release_status;
	}

	/**
	 * 获取发布时间
	 * @return
	 */
	public Integer getDeploy_machine_num() {
		return deploy_machine_num;
	}

	/**
	 * 设置发布时间
	 * @param deploy_machine_num
	 */
	public void setDeploy_machine_num(Integer deploy_machine_num) {
		this.deploy_machine_num = deploy_machine_num;
	}

	/**
	 * 获取修改时间
	 * @return
	 */
	public String getInsert_datetime() {
		return insert_datetime;
	}
	
	/**
	 * 设置修改时间
	 * @param insert_datetime
	 */
	public void setInsert_datetime(String insert_datetime) {
		this.insert_datetime = insert_datetime;
	}

	/**
	 * 获取新增添加者
	 * @return
	 */
	public String getInsert_user_name() {
		return insert_user_name;
	}

	/**
	 * 设置设置添加者
	 * @param insert_user_name
	 */
	public void setInsert_user_name(String insert_user_name) {
		this.insert_user_name = insert_user_name;
	}

	/**
	 * 获取更新时间
	 * @return
	 */
	public String getUpdate_datetime() {
		return update_datetime;
	}

	/**
	 * 设置更新时间
	 * @param update_datetime
	 */
	public void setUpdate_datetime(String update_datetime) {
		this.update_datetime = update_datetime;
	}

	/**
	 * 获取更新用户
	 * @return
	 */
	public String getUpdate_user_name() {
		return update_user_name;
	}

	/**
	 * 修改更新用户
	 * @param update_user_name
	 */
	public void setUpdate_user_name(String update_user_name) {
		this.update_user_name = update_user_name;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	

}
