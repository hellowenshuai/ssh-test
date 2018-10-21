package com.fuji.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 银行表实体类
 */
public class Bank implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ID*/
    private String bank_id;
    /** 名称 */
    private String bank_name;
	/**
	 * 一对多，一个银行多个素材
	 */
	private Set<Material> saleVisits = new HashSet<Material>();
	
	public Set<Material> getSaleVisits() {
		return saleVisits;
	}
	public void setSaleVisits(Set<Material> saleVisits) {
		this.saleVisits = saleVisits;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	


}
