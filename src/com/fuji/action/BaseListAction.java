package com.fuji.action;

import java.util.List;

import com.fuji.bean.Bank;
import com.fuji.common.Constants;
import com.fuji.common.Pager;

/**
 * 一览Action基类
 */
public class BaseListAction extends BaseAction {

    /** 序列号 */
    private static final long serialVersionUID = -4508436046942872628L;
    /** 分页类型 */
    public String turnPageType;
    /** 当前页码 */
    public String currentPage;
    /** 分页信息 */
    public Pager pager;
    /** 一览结果 */
    public List list;
    /** 一览总行数 */
    public int totalRows;
    /** 处理区分 */
    public String execFlag;

    /**
     * 检索条件_银行ID初始化设置
     *
     * @param hasAllBank 全部银行显示有无
     * @return 检索条件_银行ID
     */
    public String initBankIdForSearch(boolean hasAllBank) {

        String bankId = null;

        // 用户权限取得
        String userPriority = getUserPriorityFromSession();
        // 用户所属银行ID取得
        String userBankId = getUserBankIdFromSession();

        bankId = userBankId;

        if (hasAllBank) {

            if (Constants.VALUE_PRIORITY_SUPER_USER.equals(userPriority)) {
                bankId = Constants.OPTION_KEY_ALL_BANK;
            }
        } else {
            if (Constants.VALUE_PRIORITY_SUPER_USER.equals(userPriority)) {
                List<Bank> userBankList = getUserBankListFromSession();
                bankId = userBankList.get(0).getBank_id();
            }
        }

        return bankId;
    }

}
