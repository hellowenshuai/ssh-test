package com.fuji.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.fuji.common.CommonUtil;
import com.fuji.common.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * session过期检查拦截器
 *
 */
public class SessionInterceptor extends AbstractInterceptor {

    /** 序列号 */
    private static final long serialVersionUID = 4965512250455619651L;

    /**
     * 拦截处理
     */
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) ctx.getContext().get(
                ServletActionContext.HTTP_REQUEST);

        Map session = ctx.getSession();

        ActionMapping actionMapping = (ActionMapping) request
                .getAttribute("struts.actionMapping");
        String actionName = actionMapping.getName();

        // 用户登录/用户退出时，不需要检查session
        if ("userLogin".equals(actionName) || "userLogout".equals(actionName)) {
            return invocation.invoke();
        } else {
            if (CommonUtil.isEmpty(session)
                    || CommonUtil.isEmpty(session
                            .get(Constants.SESSION_KEY_USER_NAME))) {
                // session为空，或者session中用户名取得失败的场合
                request.setAttribute(
                        Constants.REQUEST_KEY_SYSTEM_ERROR,
                        CommonUtil
                                .getMessage(Constants.KEY_SESSION_TIMEOUT_ERROR));
                request.setAttribute(Constants.REQUEST_KEY_CONTINUE_AFTER_ERROR,
                        Constants.VALUE_CONTINUE_AFTER_ERROR_DISABEL);
                return "sessionTimeout";
            } else {
                return invocation.invoke();
            }

        }

    }
}
