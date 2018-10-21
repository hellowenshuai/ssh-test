package com.fuji.dao;

import java.util.List;

import com.fuji.bean.User;
import com.fuji.bean.UserListShow;

/**
 * 用户表DAO
 *
 */
public interface UserDAO {
    /**
     * 用户表保存
     *
     * @param user
     *            用户信息
     * @throws Exception
     *             异常
     */
    public void saveUser(User user) throws Exception;

    /**
     * 用户表信息删除
     *
     * @param user
     *            用户信息
     * @throws Exception
     *             异常
     */
    public void removeUser(User user) throws Exception;

    /**
     * 用户信息查询
     *
     * @param id
     *            用户ID
     * @return 结果集
     */
    public User findUserById(Integer id);

    /**
     * 用户表全件查询
     *
     * @return 结果集
     */
    public List<User> findAllUser();

    /**
     * 用户表更新
     *
     * @param user
     *            用户信息
     * @return 
     * @throws Exception
     *             异常
     */
    public Integer updateUserByPriority(User user) throws Exception;
    /**
     * 用户表更新
     *
     * @param user
     *            用户信息
     * @return 
     * @throws Exception
     *             异常
     */
    public void updateUserByPassword(User user) throws Exception;

    /**
     * 用户信息查询
     *
     * @param name
     *            用户名
     * @param password
     *            密码
     * @return 结果集
     */
    public List<User> findByNamePassword(String name, String password);

    /**
     * 用户信息查询
     *
     * @param bankId
     *            银行ID
     * @param userName
     *            用户名
     * @return 结果集
     */
    public int findUserListCount(String bankId, String userName);

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
    public List<UserListShow> findUserListShow(String bankId, String userName,
            int startRowNo, int pageSize);

    /**
     * 用户信息查询
     *
     * @param userName
     *            用户名
     * @return 结果集
     */
    public List<User> findByName(String userName);

    /**
     * 用户信息查询
     *
     * @param userName
     *            用户名
     * @param updateDatetime
     *            更新时间
     * @return 结果集
     */
    public List<User> findUser(String userName, String updateDatetime);
    //保存用户
	public Integer addUser(User user);

	public 	Object findUserByName(String name);

}
