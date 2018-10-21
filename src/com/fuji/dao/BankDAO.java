package com.fuji.dao;

import java.util.List;

import com.fuji.bean.Bank;

/**
 * 银行DAO
 *
 */
public interface BankDAO {

    /**
     * 银行信息保存
     * @param bank 银行信息
     */
    public void saveBank(Bank bank);

    /**
     * 银行信息删除
     * @param bank 银行信息
     */
    public void removeBank(Bank bank);

    /**
     * 指定ID的银行信息查询
     * @param id 银行ID
     * @return 对象银行信息
     */
    public Bank findBankById(String id);

    /**
     * 全部银行信息取得
     * @return 结果集
     */
    public List<Bank> findAllBank();

    /**
     * 全部银行（ID：000）以外的银行信息取得
     * @return 结果集
     */
    public List<Bank> findBankExceptALL();

    /**
     * 银行信息更新
     * @param bank 银行信息
     */
    public void updateBank(Bank bank);

}
