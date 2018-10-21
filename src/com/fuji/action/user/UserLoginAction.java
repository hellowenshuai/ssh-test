package com.fuji.action.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fuji.action.BaseAction;
import com.fuji.bean.Bank;
import com.fuji.bean.User;
import com.fuji.common.CommonUtil;
import com.fuji.common.Constants;
import com.fuji.service.BankService;
import com.fuji.service.UserService;

/**
 * 用户登录
 */
public class UserLoginAction extends BaseAction {
    /** 序列号 */
    private static final long serialVersionUID = -1098703356037164349L;
    /** 用户信息 */
    private User user;
    /** 用户service */
    private UserService service;
    /** 银行service */
    private BankService bankService;
    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(UserLoginAction.class);

    /**
     * 用户信息取得
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * 用户信息设定
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 用户service取得
     *
     * @return
     */
    public UserService getService() {
        return service;
    }

    /**
     * 用户service设定
     *
     * @param service
     */
    public void setService(UserService service) {
        this.service = service;
    }

    /**
     * 银行service取得
     *
     * @return
     */
    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    /**
     * 用户登录处理
     */
    @Override
    public String execute() throws Exception {

        sLogger.info(appendCommonMsg("execute() start"));
        String result = ERROR;

        // 画面输入信息是否为空
        boolean isChecked = checkData();

        if (isChecked) {
            String nameInput = user.getName();
            String passwordInput = user.getPassword();

            // 执行查询处理
            List<User> userList = service.findByNamePassword(nameInput,
                    passwordInput);

            if (CommonUtil.isEmpty(userList)) {
                // 用户名,密码不匹配的场合
                addActionError(CommonUtil
                        .getMessage(Constants.KEY_USER_PASSWORD_ERROR));
                result = ERROR;

            } else {
                int size = userList.size();

                if (size > 0) {

                    // 用户信息取得
                    User loginUser = userList.get(0);
                    String userPriority = loginUser.getPriority();
                    String bankId = loginUser.getBank_id();

                    // 用户信息设置到session里
                    mSession.put(Constants.SESSION_KEY_USER_NAME,
                            loginUser.getName());
                    mSession.put(Constants.SESSION_KEY_USER_PRIORITY,
                            userPriority);
                    mSession.put(Constants.SESSION_KEY_USER_BANK_ID, bankId);

                    // 银行信息取得
                    List<Bank> bankList;
                    if (Constants.VALUE_PRIORITY_SUPER_USER
                            .equals(userPriority)) {
                        bankList = bankService.findExceptALL();
                    } else {
                        Bank bank = bankService.findById(bankId);
                        bankList = new ArrayList<Bank>();
                        bankList.add(bank);
                    }

                    // 银行信息设置到session里
                    mSession.put(Constants.SESSION_KEY_BANK_LIST, bankList);

                    result = SUCCESS;
                }

            }

        } else {
            result = ERROR;
        }
        sLogger.info(appendCommonMsg("execute() end, result = " + result));
        return result;

    }

    /**
     * 画面输入数据有效性检查
     * @return 检查结果
     */
    private boolean checkData() {

        sLogger.info(appendCommonMsg("checkData() start"));
        boolean isChecked = true;

        if (CommonUtil.isEmpty(user)) {

            addActionError(CommonUtil.getMessage(Constants.KEY_NONE_LOGIN_INFO));
            isChecked = false;
        }

        if (isChecked) {
            if (CommonUtil.isEmpty(user.getName())) {

                addActionError(CommonUtil.getMessage(Constants.KEY_USER_NAME_NULL));
                isChecked = false;
            }
        }

        if (isChecked) {
            if (CommonUtil.isEmpty(user.getPassword())) {

                addActionError(CommonUtil
                        .getMessage(Constants.KEY_USER_PASSWORD_NULL));
                isChecked = false;

            }
        }

        sLogger.info(appendCommonMsg("checkData() end, isChecked = " + isChecked));
        return isChecked;
    }
}
