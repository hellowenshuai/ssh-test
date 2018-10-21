package com.fuji.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fuji.bean.User;
import com.fuji.bean.UserListShow;
import com.fuji.dao.UserDAO;
import com.fuji.service.UserService;

/**
 * 用户表Service实例
 *
 */
public class UserServiceImpl implements UserService {

    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(UserServiceImpl.class);


    /** 用户DAO */
    private UserDAO userDao;

    /**
     * 用户DAO取得
     *
     * @return 用户DAO
     */
    public UserDAO getUserDao() {
        return userDao;
    }

    /**
     * 用户DAO设定
     *
     * @param userDao
     *            用户DAO
     */
    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    /**
     * 用户表全件查询
     *
     * @return 结果集
     */
    public List<User> findAll() {

        return this.userDao.findAllUser();

    }

    /**
     * 用户信息查询
     *
     * @param id
     *            用户ID
     * @return 结果集
     */
    public User findById(Integer id) {

        return this.userDao.findUserById(id);

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
        return this.userDao.findByNamePassword(name, password);
    }

    /**
     * 输入数据流取得
     *
     * @return 输入数据流
     */
    public InputStream getInputStream() {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFRow row = sheet.createRow(0);

        HSSFCell cell = row.createCell((short) 0);
        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue("No.");

        cell = row.createCell((short) 1);
        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue("用户ID");

        cell = row.createCell((short) 2);
        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue("用户名");

        cell = row.createCell((short) 3);
        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue("密码");

        List<User> list = this.findAll();

        for (int i = 0; i < list.size(); ++i) {

            User user = list.get(i);

            row = sheet.createRow(i + 1);

            cell = row.createCell((short) 0);
            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue(i + 1);

            cell = row.createCell((short) 1);
            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue(user.getId());

            cell = row.createCell((short) 2);
            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue(user.getName());

            cell = row.createCell((short) 3);
            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
            cell.setCellValue(user.getPassword());

        }

        File file = new File("test.xls");

        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
            sLogger.error(e.getStackTrace());
        }

        InputStream is = null;

        try {
            is = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sLogger.error(e.getStackTrace());

        }

        return is;
    }

    /**
     * 用户信息查询
     *
     * @param bankId
     *            银行ID
     * @param userName
     *            用户名
     * @return 件数
     */
    @Override
    public int findUserListCount(String bankId, String userName) {
        return this.userDao.findUserListCount(bankId, userName);
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
        return this.userDao.findUserListShow(bankId, userName, startRowNo,
                pageSize);
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
        return this.userDao.findByName(userName);
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
    public List<User> findUser(String userName, String updateDatetime) {
        return this.userDao.findUser(userName, updateDatetime);
    }
    //添加
  	@Override
  	public Integer addUser(User user) {
  		Integer resultTotal=userDao.addUser(user);
  		return resultTotal;
  	}

  	@Override
  	public Object findUserByName(String name) {
  		Object object=userDao.findUserByName(name);
  		return object;
  	}

	@Override
	public Integer updateUserByPriority(User user) {
		Integer resultTotal=0;
		try {
			resultTotal = userDao.updateUserByPriority(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultTotal;
	}

	@Override
	public void ModifyPassword(String name, String rePassword01,String loginName) {
		User user = null;
		List<User> users = userDao.findByName(name);
		if (users != null && users.size() > 0) {
			user = users.get(0);
		}
		user.setName(name);
		user.setPassword(rePassword01);
		Date update_datetime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd000000");
		user.setUpdate_datetime(sdf.format(update_datetime));
		user.setUpdate_user_name(loginName);
		try {
			userDao.updateUserByPassword(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
  	
  	


}
