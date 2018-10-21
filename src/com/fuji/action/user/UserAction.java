package com.fuji.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.fuji.bean.User;
import com.fuji.service.UserService;
import com.fuji.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private User user=new User();
	private UserService userService;
 
	
	

	




	public String addUser() throws Exception {
		
		String name = user.getName();
		Integer resultTotal=0;
		//根据用户名查找用户对象
		Object object=userService.findUserByName(name);
		HttpServletRequest request = ServletActionContext.getRequest();
		//如果查到输出用户名已存在
		if(object==null){
			resultTotal=userService.addUser(user);
			if (resultTotal>0) {
				request.setAttribute("success","用户添加成功");
			}
			
		}else{
			request.setAttribute("error","用户名已存在");
		}
		return "addUser";
	}

	
	

 

	

	public UserService getUserService() {
		return userService;
	}








	public void setUserService(UserService userService) {
		this.userService = userService;
	}








	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
