package com.fuji.action.user;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fuji.action.BaseAction;

/**
 * 用户退出Action
 */
public class UserLogoutAction extends BaseAction {
    /** 序列号 */
    private static final long serialVersionUID = -1098703356037164349L;

    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(UserLogoutAction.class);

    @Override
    public String execute() throws Exception {

        sLogger.info(appendCommonMsg("execute() start"));

        // session清除
        mSession.clear();

        sLogger.info(appendCommonMsg("execute() end"));
        return SUCCESS;
    }

}
