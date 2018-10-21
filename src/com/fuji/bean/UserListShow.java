package com.fuji.bean;

public class UserListShow {
    /** 银行名 */
    private String bank_name;
    /** 银行ID */
    private String bank_Id;
    /** 用户ID */
    private Integer userId;
    /** 用户名 */
    private String name;
    /** 说明 */
    private String instruction;
    /** 用户权限 */
    private String priority;
    /** 更新时间 */
    private String update_datetime;

    /**
     * 取得bank_name
     *
     * @return bank_name
     */
    public String getBank_name() {
        return bank_name;
    }

    /**
     * 设定bank_name
     *
     * @param bank_name
     */
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    /**
     * 取得bank_Id
     *
     * @return bank_Id
     */
    public String getBank_Id() {
        return bank_Id;
    }

    /**
     * 设定bank_Id
     *
     * @param bank_Id
     */
    public void setBank_Id(String bank_Id) {
        this.bank_Id = bank_Id;
    }

    /**
     * 取得userId
     *
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设定userId
     *
     * @param Integer
     *            userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 取得name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设定name
     *
     * @param String
     *            name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 取得priority
     *
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * 设定priority
     *
     * @param String
     *            priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 取得instruction
     *
     * @return instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * 设定instruction
     *
     * @param String
     *            instruction
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * 取得update_datetime
     *
     * @return update_datetime
     */
    public String getUpdate_datetime() {
        return update_datetime;
    }

    /**
     * 设定update_datetime
     *
     * @param String
     *            update_datetime
     */
    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }

}
