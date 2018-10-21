package com.fuji.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.fuji.bean.Bank;
import com.fuji.bean.Material;
import com.fuji.common.Constants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action基类
 */
public class BaseAction extends ActionSupport implements SessionAware,
        ServletResponseAware, ServletRequestAware {

    /** 序列号 */
    private static final long serialVersionUID = 157487264828656991L;

    /** 会话对象 */
    protected Map<String, Object> mSession;

    /** 响应对象 */
    protected HttpServletResponse mResponse;

    /** 请求对象 */
    protected HttpServletRequest mRequest;

    @Override
    public void setServletRequest(HttpServletRequest arg0) {
        this.mRequest = arg0;

    }

    @Override
    public void setServletResponse(HttpServletResponse arg0) {
        this.mResponse = arg0;

    }

    @Override
    public void setSession(Map arg0) {
        this.mSession = arg0;
    }

    /**
     * session值取得.
     *
     * @param strName
     *            session变量名
     * @return session变量值
     */
    public final Object getSession(String strName) {
        Object obj;

        if (null == mSession.get(strName)) {
            return null;
        } else {
            obj = mSession.get(strName);
        }
        return obj;
    }

    /**
     * session变量删除
     *
     * @param strName
     *            session变量名
     */
    public final void delSession(String strName) {

        this.mSession.remove(strName);
    }

    /**
     * 用户权限取得
     *
     * @return 用户权限
     */
    public final String getUserPriorityFromSession() {
        String userPriority = (String) getSession(Constants.SESSION_KEY_USER_PRIORITY);
        return userPriority;
    }

    /**
     * 用户名取得
     *
     * @return 用户名
     */
    public final String getUserNameFromSession() {
        String userName = (String) getSession(Constants.SESSION_KEY_USER_NAME);
        return userName;
    }

    /**
     * 用户所属银行ID取得
     *
     * @return 用户所属银行ID
     */
    public final String getUserBankIdFromSession() {
        String userBankId = (String) getSession(Constants.SESSION_KEY_USER_BANK_ID);
        return userBankId;
    }

    /**
     * 日志输出时共通信息追加
     * @param msg
     * @return 日志输出文本
     */
    public final String appendCommonMsg(String msg) {

        StringBuffer sb = new StringBuffer(msg);
        sb.append(" ---- ");
        sb.append("operated by user[");
        sb.append(getUserNameFromSession());
        sb.append("] of bank[");
        sb.append(getUserBankIdFromSession());
        sb.append("] ");

        return sb.toString();

    }

    /**
     * session中存在的银行list取得
     *
     * @return 银行list
     */
    public final List<Bank> getUserBankListFromSession() {
        List<Bank> bankList =(List<Bank>) getSession(Constants.SESSION_KEY_BANK_LIST);
        return bankList;
    }
    /**
     * session中存在的素材list取得
     *
     * @return 素材list
     */
    public final List<Material> getUserMaterialListFromSession() {
    	List<Material> materialList =(List<Material>) getSession(Constants.SESSION_KEY_MATERIAL_LIST);
    	return materialList;
    }
    
    /**
     * 素材类型取得
     *
     * @return 素材类型
     */
    public final String getMaterialTypeFromSession() {
        String material_type = (String) getSession(Constants.SESSION_KEY_MATERIAL_TYPE);
        return material_type;
    }
    /**
     * 素材版本取得
     *
     * @return 素材版本
     */
    public final String getMaterialVersionFromSession() {
    	String material_version = (String) getSession(Constants.SESSION_KEY_MATERIAL_VERSION);
    	return material_version;
    }
    /**
     * 素材备注取得
     *
     * @return 素材备注
     */
    public final String getRemarkFromSession() {
    	String remark = (String) getSession(Constants.SESSION_KEY_MATERIAL_REMARK);
    	return remark;
    }


}
