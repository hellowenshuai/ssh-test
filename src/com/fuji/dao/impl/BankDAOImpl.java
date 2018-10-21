package com.fuji.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fuji.bean.Bank;
import com.fuji.dao.BankDAO;

/**
 * 银行DAO实例
 *
 */
public class BankDAOImpl extends HibernateDaoSupport implements BankDAO {

    /**
     * 全部银行信息取得
     *
     * @return 结果集
     */
    public List<Bank> findAllBank() {

        String hql = "from Bank bank order by bank.bank_id ";

        return (List<Bank>) this.getHibernateTemplate().find(hql);

    }

    /**
     * 全部银行（ID：000）以外的银行信息取得
     *
     * @return 结果集
     */
    public List<Bank> findBankExceptALL() {

        String hql = "from Bank bank where bank.bank_id != '000' order by bank.bank_id ";

        return (List<Bank>) this.getHibernateTemplate().find(hql);

    }

    /**
     * 指定ID的银行信息查询
     *
     * @param id
     *            银行ID
     * @return 对象银行信息
     */
    public Bank findBankById(String id) {

        Bank user = (Bank) this.getHibernateTemplate().get(Bank.class, id);

        return user;
    }

    /**
     * 银行信息删除
     *
     * @param bank
     *            银行信息
     */
    public void removeBank(Bank bank) {

        this.getHibernateTemplate().delete(bank);

    }

    /**
     * 银行信息保存
     *
     * @param bank
     *            银行信息
     */
    public void saveBank(Bank bank) {

        this.getHibernateTemplate().save(bank);

    }

    /**
     * 银行信息更新
     *
     * @param bank
     *            银行信息
     */
    public void updateBank(Bank bank) {

        this.getHibernateTemplate().update(bank);

    }

}
