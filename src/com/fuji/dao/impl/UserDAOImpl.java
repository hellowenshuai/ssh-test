package com.fuji.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fuji.bean.User;
import com.fuji.bean.UserListShow;
import com.fuji.common.CommonUtil;
import com.fuji.dao.UserDAO;

/**
 * 用户表DAO实例
 *
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

    /** key_件数取得用sql */
    private static String KEY_SQL_COUNT = "sqlCount";
    /** key_一览取得用sql */
    private static String KEY_SQL_LIST = "sqlList";
    /** key_参数集 */
    private static String KEY_PARAMS = "params";

    /**
     * 用户表全件查询
     *
     * @return 结果集
     */
    public List<User> findAllUser() {

        String hql = "from User user order by user.id desc";

        return (List<User>) this.getHibernateTemplate().find(hql);

    }

    /**
     * 用户信息查询
     *
     * @param id
     *            用户ID
     * @return 结果集
     */
    public User findUserById(Integer id) {

        User user = (User) this.getHibernateTemplate().get(User.class, id);

        return user;
    }

    /**
     * 用户信息查询
     *
     * @param name
     *            用户名
     * @param password
     *            密码
     * @return 结果集
     */
    public List<User> findByNamePassword(String name, String password) {

        String hql = " from User user where user.name = ? and user.password = ? ";

        return (List<User>) this.getHibernateTemplate().find(hql,
                new Object[] { name, password });
    }

    /**
     * 用户表信息删除
     *
     * @param user
     *            用户信息
     * @throws Exception
     *             异常
     */
    public void removeUser(User user) throws Exception {

        this.getHibernateTemplate().delete(user);

    }

    /**
     * 用户表保存
     *
     * @param user
     *            用户信息
     * @throws Exception
     *             异常
     */
    public void saveUser(User user) throws Exception {

        this.getHibernateTemplate().save(user);

    }

    /**
     * 用户表更新
     *
     * @param user
     *            用户信息
     * @throws Exception
     *             异常
     */
    public void updateUser(User user) throws Exception {

        this.getHibernateTemplate().update(user);

    }

    /**
     * 用户信息sql语句拼接，并存储在Map结构中
     *
     * @param bankId
     *            银行ID
     * @param userName
     *            用户名
     * @return Map
     */
    private Map<String, Object> makeSqlForUserListShow(String bankId,
            String userName) {

        Map<String, Object> result = new Hashtable<String, Object>();
        boolean hasWhere = false;

        StringBuffer countSelect = new StringBuffer(
                " select count(*) as totalRows ");
        StringBuffer listSelect = new StringBuffer(
                " select bank.bank_name as bankName, {users.*}");

        StringBuffer sb = new StringBuffer(
                " from bank inner join users on (bank.bank_id = users.bank_id) ");

        ArrayList<String> params = new ArrayList<String>();

        if (!CommonUtil.isEmpty(bankId)) {
            sb.append(" where ");
            hasWhere = true;
            sb.append(" users.bank_id = ? ");
            params.add(bankId);
        }

        if (!CommonUtil.isEmpty(userName)) {
            hasWhere = CommonUtil.appendWhereOrAndSqlMark(hasWhere, sb);
            sb.append(" users.name like ? ");
            params.add("%" + userName + "%");
        }

        String sqlCount = countSelect.append(sb).toString();
        String sqlList = listSelect.append(sb).toString();

        result.put(KEY_SQL_COUNT, sqlCount);
        result.put(KEY_SQL_LIST, sqlList);
        result.put(KEY_PARAMS, params);

        return result;
    }

    /**
     * 用户信息查询
     *
     * @param bankId
     *            银行ID
     * @param userName
     *            用户名
     * @return 结果集
     */
    @Override
    public int findUserListCount(String bankId, String userName) {
        int result = 0;

        // sql作成
        Map<String, Object> sqlMap = makeSqlForUserListShow(bankId, userName);
        String sql = (String) sqlMap.get(KEY_SQL_COUNT);
        List<String> params = (List<String>) sqlMap.get(KEY_PARAMS);

        Session session = this.getHibernateTemplate().getSessionFactory()
                .openSession();

        SQLQuery query = session.createSQLQuery(sql).addScalar("totalRows",
                Hibernate.INTEGER);

        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i, params.get(i));
        }

        List list = query.list();

        session.close();

        // 查询结果转化到画面表示用的对象里
        if (!CommonUtil.isEmpty(list)) {

            result = ((Integer) list.get(0)).intValue();

        }

        return result;
    }

    /**
     * 用户信息查询
     *
     * @param bankId
     *            银行ID
     * @param userName
     *            用户名
     * @param startRowNo
     *            开始行号
     * @param pageSize
     *            每页表示行数
     * @return 结果集
     */
    @Override
    public List<UserListShow> findUserListShow(String bankId, String userName,
            int startRowNo, int pageSize) {

        List<UserListShow> resultList = new ArrayList<UserListShow>();

        // sql作成
        Map<String, Object> sqlMap = makeSqlForUserListShow(bankId, userName);
        String sql = (String) sqlMap.get(KEY_SQL_LIST);
        List<String> params = (List<String>) sqlMap.get(KEY_PARAMS);

        Session session = this.getHibernateTemplate().getSessionFactory()
                .openSession();

        SQLQuery query = session.createSQLQuery(sql)
                .addScalar("bankName", Hibernate.STRING)
                .addEntity("users", User.class);

        query.setFirstResult(startRowNo);
        query.setMaxResults(pageSize);

        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i, params.get(i));
        }

        List list = query.list();

        session.close();

        // 查询结果转化到画面表示用的对象里
        if (!CommonUtil.isEmpty(list)) {

            for (int i = 0; i < list.size(); i++) {
                Object[] obj = (Object[]) list.get(i);
                UserListShow show = new UserListShow();
                String bankName = (String) (obj[0]);
                User user = (User) (obj[1]);

                show.setBank_name(bankName);
                show.setName(user.getName());
                show.setInstruction(user.getInstruction());
                show.setPriority(user.getPriority());
                show.setBank_Id(user.getBank_id());
                show.setUserId(user.getId());
                show.setUpdate_datetime(user.getUpdate_datetime());

                resultList.add(show);
            }

        }
        return resultList;
    }

    /**
     * 用户信息查询
     *
     * @param userName
     *            用户名
     * @return 结果集
     */
    @Override
    public List<User> findByName(String userName) {

        String hql = " from User user where user.name = ? ";

        return (List<User>) this.getHibernateTemplate().find(hql,
                new Object[] { userName });

    }

    /**
     * 用户信息查询
     *
     * @param userName
     *            用户名
     * @param updateDatetime
     *            更新时间
     * @return 结果集
     */
    @Override
    public List<User> findUser(String userName, String updateDatetime) {

        String hql = " from User user where user.name = ? and user.update_datetime = ?";

        return (List<User>) this.getHibernateTemplate().find(hql,
                new Object[] { userName, updateDatetime });

    }
    /**
     * 用户信息保存
     */
	@Override
	public Integer addUser(User user) {
		Session session = this.getSession();
		String sql="insert into users set bank_id=?, name=?, password=?,priority=?,instruction=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0,user.getBank_id());
		query.setString(1,user.getName());
		query.setString(2,user.getPassword());
		query.setString(3,user.getPriority());
		query.setString(4,user.getInstruction());
		int update = query.executeUpdate();
		return update;
	}

	@Override
	public Object findUserByName(String name) {
		Session session = this.getSession();
		String sql="select * from users where name=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0, name);
		Object result = query.uniqueResult();
		
		return result;
	}
	
	@Override
	public Integer updateUserByPriority(User user) {
		
		Session session = this.getSession();
		String sql="update users set priority=? where name=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setString(0,user.getPriority());
		query.setString(1,user.getName());
		int update = query.executeUpdate();
		return update;
	}

	/* (non-Javadoc)
	 * @see com.fuji.dao.UserDAO#updateUserByPassword(com.fuji.bean.User)
	 */
	@Override
	public void updateUserByPassword(User user) throws Exception {
		 this.getHibernateTemplate().update(user);
	}
}
