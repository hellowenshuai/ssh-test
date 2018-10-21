package com.fuji.action.user;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fuji.action.BaseAction;
import com.fuji.action.BaseListAction;
import com.fuji.bean.User;
import com.fuji.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

public class ModifyPermissionsAction extends BaseAction implements ModelDriven<User>{

	private User user=new User();
	
	private String userName;
	
	private UserService userService;

	public String update() throws Exception {
		
		 Integer resultTotal=0;
		 HttpServletRequest request = ServletActionContext.getRequest();
		 resultTotal=userService.updateUserByPriority(user);
		 request.setAttribute("user",user);
		 request.setAttribute("userName",userName);
		 if(resultTotal>0){
			 request.setAttribute("success", "权限修改成功！");
		 }else{
			 request.setAttribute("error", "权限修改失败！");
		 }

		return "modifyPermission";
	}

	
	
	@Override
	public User getModel() {
		
		return user;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
