/**
 * 
 */
package com.fuji.action.user;

import java.util.List;

import com.fuji.action.BaseAction;
import com.fuji.bean.User;
import com.fuji.common.Constants;
import com.fuji.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 密码修改
 * @author chenshuai
 * 
 */

public class ModifyPasswordAction extends BaseAction implements
		ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	// 用户 模型驱动
	private User user = new User();
	//新密码 属性驱动
	private String rePassword01;
	//确认密码
	private String rePassword02;

	// servcie
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 跳转到密码修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toEdit() throws Exception {

		Integer isSelf = 1;// 是否显示原密码输入框标识，1显示，2不显示
		// 1.获取当前修改用户name
		String editName = (String) mRequest.getAttribute("name");
		// 获取要修改用户的所有信息
		List<User> editUser = userService.findByName(editName);
		// 2.从session中获取当前登陆用户的name
		String loginName = (String) mSession
				.get(Constants.SESSION_KEY_USER_NAME);
		if (loginName.equals(editName)) {// 一致，需要显示原密码输入框
			mRequest.setAttribute("isSelf", isSelf);
			return "edit";
		} else {// 用户名不一致
			isSelf = 2;// 不需要原密码输入框
			// 比较修改权限
			if (editUser != null && editUser.size() > 0) {//判断当前要修改的用户是否存在
				Integer intPriority = Integer.parseInt((String) mSession.get("userPriority"));// 登陆者的权限
				Integer intPriority2 = Integer.parseInt(editUser.get(0).getPriority());// 被修改者的权限
				if (intPriority < intPriority2) {// 符合权限要求
					mRequest.setAttribute("isSelf", isSelf);
					return "edit";
				} else {// 权限不足
					return "noPriority";
				}
			}
		}

		mRequest.setAttribute("isSelf", isSelf);
		return "edit";
	}

	// 修改密码

	public String editPassword() throws Exception {
		Integer isSelf = 2;// 默认没有原密码输入框
		String message = null;

		// 登陆的用户名
		String loginName = (String) mSession
				.get(Constants.SESSION_KEY_USER_NAME);

		// 前端传过的用户名是否存在
		String userName = user.getName();

		if (userName.equals(loginName)) {
			String password = (String) mRequest.getAttribute("password");
			String sessionPassword = (String) userService.findByName(loginName)
					.get(0).getPassword();
			if (password.equals(sessionPassword)) {
				String rePassword01 = (String) mRequest
						.getAttribute("rePassword01").toString().trim();
				userService.ModifyPassword(userName, rePassword01, loginName);
				return "yes";
			} else {
				isSelf = 1;// 显示原密码输入框
				message = "原密码输入错误！";
				mRequest.setAttribute("isSelf", isSelf);
				mRequest.setAttribute("message", message);
				return "edit";
			}
		}
		String rePassword01 = (String) mRequest.getAttribute("rePassword01");
		userService.ModifyPassword(userName, rePassword01, loginName);
		return "listUser";
	}

	@Override
	public User getModel() {
		return user;
	}

	public String getRePassword01() {
		return rePassword01;
	}

	public void setRePassword01(String rePassword01) {
		this.rePassword01 = rePassword01;
	}

	public String getRePassword02() {
		return rePassword02;
	}

	public void setRePassword02(String rePassword02) {
		this.rePassword02 = rePassword02;
	}

}
