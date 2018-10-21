package com.fuji.service;

import java.io.InputStream;
import java.util.List;

import com.fuji.bean.User;
import com.fuji.bean.UserListShow;

/**
 * 用户表Service
 *
 */
public interface UserService {

    /**
     * 用户表全件查询
     *
     * @return 结果集
     */
    public List<User> findAll();

    /**
     * 用户信息查询
     *
     * @param id
     *            用户ID
     * @return 结果集
     */
    public User findById(Integer id);

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
     * 输入数据流取得
     *
     * @return 输入数据流
     */
    public InputStream getInputStream();

    /**
     * 用户信息查询
     *
     * @param bankId
     *            银行ID
     * @param userName
     *            用户名
     * @return 件数
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
    //添加用户
  	public Integer addUser(User user);

  	public Object findUserByName(String name);

	public Integer updateUserByPriority(User user);

	/**
	 * 用户密码修改
	 * @param userName
	 * @param rePassword01
	 * @param loginName
	 */
	public void ModifyPassword(String userName, String rePassword01,
			String loginName);

}
