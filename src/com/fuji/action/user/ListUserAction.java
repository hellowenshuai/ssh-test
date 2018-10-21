package com.fuji.action.user;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fuji.action.BaseListAction;
import com.fuji.common.CommonUtil;
import com.fuji.common.Constants;
import com.fuji.common.PagerHelp;
import com.fuji.service.UserService;
/**
 * 用户一览
 *
 */
public class ListUserAction extends BaseListAction {
    /** 序列号 */
    private static final long serialVersionUID = -8120532615117098102L;
    /** 银行ID */
    public String bankId;
    /** 用户名 */
    public String userName;
    /** 用户名（内部记录用） */
    private String userNameOrgin;
    /** 银行ID（内部记录用） */
    private String bankIdOrgin;
    /** 操作对象银行ID */
    public String bankIdOperation;
    /** 操作对象用户名 */
    public String userNameOperation;
    /** 操作对象用户权限 */
    public String userPriorityOperation;
    /** 操作对象更新时间 */
    public String updateDatetimeOperation;

    /** 验证错误有无判定 */
    public boolean hassError = false;
    /** service */
    private UserService service;

    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(ListUserAction.class);

    /**
     * 取得service
     *
     * @return
     */
    public UserService getService() {
        return service;
    }

    /**
     * 设定service
     *
     * @param service
     */
    public void setService(UserService service) {
        this.service = service;
    }

    /**
     * 初始化处理
     *
     * @return
     * @throws Exception
     */
    public String init() throws Exception {

        sLogger.info(appendCommonMsg("init() start"));

        if (!CommonUtil.isEmpty(bankIdOrgin)
                || !CommonUtil.isEmpty(userNameOrgin)) {
            bankId = bankIdOrgin;
            userName = userNameOrgin;
        } else {
            // 用户权限取得
            String userPriority = getUserPriorityFromSession();

            // 检索条件_银行ID设置
            bankId = initBankIdForSearch(true);

            if (Constants.VALUE_PRIORITY_NORMAL.equals(userPriority)) {
                // 用户名取得
                String name = getUserNameFromSession();
                userName = name;
            }
        }
        // 一览数据检索
        findData();

        sLogger.info(appendCommonMsg("init() end"));
        return SUCCESS;
    }

    /**
     * 一览表示处理
     */
    @Override
    public String execute() throws Exception {

        sLogger.info(appendCommonMsg("execute() start"));

        // 输入数据的前后空白去除处理
        if(!" ".equals(userName)||userName!=null){
        	userName = userName.trim();
        }

        // 一览数据检索
        findData();

        sLogger.info(appendCommonMsg("execute() end"));

        return SUCCESS;
    }

    /**
     * 一览数据检索
     *
     * @throws Exception
     */
    private void findData() throws Exception {

        sLogger.info(appendCommonMsg("findData() start"));
        // SQL检索用银行ID
        String bankIdSql = CommonUtil.fixBankIdForSearch(bankId);

        // 一览总件数取得
        totalRows = service.findUserListCount(bankIdSql, userName);

        sLogger.info(appendCommonMsg("findData() : totalRows = " + totalRows));

        if (totalRows > 0) {
            // 分页信息作成
            pager = PagerHelp.getPager(currentPage, turnPageType, totalRows);
            currentPage = String.valueOf(pager.getCurrentPage());

            // 一览分页查询
            list = service.findUserListShow(bankIdSql, userName,
                    pager.getStartRow(), pager.getPageSize());

        }

        sLogger.info(appendCommonMsg("findData() end"));

    }

    /**
     * 用户名（内部记录用）取得
     *
     * @return 用户名（内部记录用）
     */
    public String getUserNameOrgin() {
        return userNameOrgin;
    }

    /**
     * 用户名（内部记录用）设定
     *
     * @param userNameOrgin
     *            用户名（内部记录用）
     */
    public void setUserNameOrgin(String userNameOrgin) {
        this.userNameOrgin = userNameOrgin;
    }

    /**
     * 银行ID（内部记录用）取得
     *
     * @return 银行ID（内部记录用）
     */
    public String getBankIdOrgin() {
        return bankIdOrgin;
    }

    /**
     * 银行ID（内部记录用）设定
     *
     * @param bankIdOrgin
     *            银行ID（内部记录用）
     */
    public void setBankIdOrgin(String bankIdOrgin) {
        this.bankIdOrgin = bankIdOrgin;
    }
}
