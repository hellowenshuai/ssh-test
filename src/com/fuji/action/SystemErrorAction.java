package com.fuji.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fuji.common.CommonUtil;
import com.fuji.common.Constants;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 系统异常Action
 *
 */
public class SystemErrorAction extends BaseAction {

    /** 序列号 */
    private static final long serialVersionUID = 7812049585113582799L;

    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(SystemErrorAction.class);

    /**
     * 异常处理
     *
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {

        sLogger.info("execute() start");

        String result = SUCCESS;

        ValueStack vs = (ValueStack) this.mRequest
                .getAttribute("struts.valueStack");
        Exception e = (Exception) vs.findValue("exception");
        Object s = vs.findValue("exceptionStack");

        // 错误信息输出到日至
        sLogger.error(e);
        sLogger.error(e.getMessage());
        sLogger.error(s);

        // 画面表示内容设定
        mRequest.setAttribute(Constants.REQUEST_KEY_SYSTEM_ERROR,
                CommonUtil.getMessage(Constants.KEY_UNKNOWN_ERROR));

        mRequest.setAttribute(Constants.REQUEST_KEY_CONTINUE_AFTER_ERROR,
                Constants.VALUE_CONTINUE_AFTER_ERROR_ENABLE);

        sLogger.info("execute() end : result = " + result);

        return result;

    }

}
