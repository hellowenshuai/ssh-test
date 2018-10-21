package com.fuji.service.impl;

import java.util.List;

import com.fuji.bean.Bank;
import com.fuji.dao.BankDAO;
import com.fuji.service.BankService;

/**
 * 银行Service实例
 *
 */
public class BankServiceImpl implements BankService {

    /** 银行DAO */
    private BankDAO bankDao;

    /**
     * 银行DAO取得
     * @return 银行DAO
     */
    public BankDAO getBankDao() {
        return bankDao;
    }

    /**
     * 银行DAO设定
     * @param bankDao 银行DAO
     */
    public void setBankDao(BankDAO bankDao) {
        this.bankDao = bankDao;
    }

    /**
     * 银行信息删除
     *
     * @param bank
     *            银行信息
     */
    public void delete(Bank bank) {

        this.bankDao.removeBank(bank);

    }

    /**
     * 全部银行信息取得
     *
     * @return 结果集
     */
    public List<Bank> findAll() {

        return this.bankDao.findAllBank();

    }

    /**
     * 指定ID的银行信息查询
     *
     * @param id
     *            银行ID
     * @return 对象银行信息
     */
    public Bank findById(String id) {

        return this.bankDao.findBankById(id);

    }

    /**
     * 银行信息保存
     *
     * @param bank
     *            银行信息
     */
    public void save(Bank bank) {

        this.bankDao.saveBank(bank);
    }

    /**
     * 银行信息更新
     *
     * @param bank
     *            银行信息
     */
    public void update(Bank bank) {

        this.bankDao.updateBank(bank);

    }

    /**
     * 全部银行（ID：000）以外的银行信息取得
     *
     * @return 结果集
     */
    public List<Bank> findExceptALL() {

        return this.bankDao.findBankExceptALL();
    }

}
