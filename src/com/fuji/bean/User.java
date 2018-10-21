package com.fuji.bean;

public class User {
    /** ID */
    private Integer id;
    /** 用户名 */
    private String name;
    /** 密码 */
    private String password;
    /** 用户权限 */
    private String priority;
    /** 银行ID */
    private String bank_id;
    /** 说明 */
    private String instruction;
    /** 登录时间 */
    private String insert_datetime;
    /** 登录者名 */
    private String insert_user_name;
    /** 更新时间 */
    private String update_datetime;
    /** 更新者名 */
    private String update_user_name;
    /**
     * 取得id
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设定id
     * @param Integer id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 取得name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * 设定name
     * @param String name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 取得password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * 设定password
     * @param String password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 取得priority
     * @return priority
     */
    public String getPriority() {
        return priority;
    }
    /**
     * 设定priority
     * @param String priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }
    /**
     * 取得bank_id
     * @return bank_id
     */
    public String getBank_id() {
        return bank_id;
    }
    /**
     * 设定bank_id
     * @param String bank_id
     */
    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }
    /**
     * 取得instruction
     * @return instruction
     */
    public String getInstruction() {
        return instruction;
    }
    /**
     * 设定instruction
     * @param String instruction
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    /**
     * 取得insert_datetime
     * @return insert_datetime
     */
    public String getInsert_datetime() {
        return insert_datetime;
    }
    /**
     * 设定insert_datetime
     * @param String insert_datetime
     */
    public void setInsert_datetime(String insert_datetime) {
        this.insert_datetime = insert_datetime;
    }
    /**
     * 取得insert_user_name
     * @return insert_user_name
     */
    public String getInsert_user_name() {
        return insert_user_name;
    }
    /**
     * 设定insert_user_name
     * @param String insert_user_name
     */
    public void setInsert_user_name(String insert_user_name) {
        this.insert_user_name = insert_user_name;
    }
    /**
     * 取得update_datetime
     * @return update_datetime
     */
    public String getUpdate_datetime() {
        return update_datetime;
    }
    /**
     * 设定update_datetime
     * @param String update_datetime
     */
    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }
    /**
     * 取得update_user_name
     * @return update_user_name
     */
    public String getUpdate_user_name() {
        return update_user_name;
    }
    /**
     * 设定update_user_name
     * @param String update_user_name
     */
    public void setUpdate_user_name(String update_user_name) {
        this.update_user_name = update_user_name;
    }


}
