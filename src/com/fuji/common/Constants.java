package com.fuji.common;

public class Constants {

    /////////////////////////
    // session用
    /////////////////////////
    /** session key_用户名*/
    public static final String SESSION_KEY_USER_NAME = "userName";
    /** session key_用户权限 */
    public static final String SESSION_KEY_USER_PRIORITY = "userPriority";
    /** session key_所属银行ID */
    public static final String SESSION_KEY_USER_BANK_ID = "userBankId";
    /** session key_银行一览*/
    public static final String SESSION_KEY_BANK_LIST = "bankList";
    /////////////////////////
    // session 素材使用
    /////////////////////////
    /** session key_类型*/
    public static final String SESSION_KEY_MATERIAL_TYPE = "material_type";
    /** session key_版本 */
    public static final String SESSION_KEY_MATERIAL_VERSION = "material_version";
    /** session key_备注 */
    public static final String SESSION_KEY_MATERIAL_REMARK = "remark";
    /** session key_素材一览*/
    public static final String SESSION_KEY_MATERIAL_LIST = "materialList";

    /** request key_系统错误 */
    public static final String REQUEST_KEY_SYSTEM_ERROR = "systemError";
    /** request key_系统错误后继续操作可否 */
    public static final String REQUEST_KEY_CONTINUE_AFTER_ERROR = "continueAfterError";

    /** request key_系统错误后继续操作可能 */
    public static final String VALUE_CONTINUE_AFTER_ERROR_ENABLE = "1";
    /** request key_系统错误后继续操作不可 */
    public static final String VALUE_CONTINUE_AFTER_ERROR_DISABEL = "0";

    /** 用户权限_超级用户 */
    public static final String VALUE_PRIORITY_SUPER_USER = "1";
    /** 用户权限_读写 */
    public static final String VALUE_PRIORITY_ADMIN = "2";
    /** 用户权限_只读 */
    public static final String VALUE_PRIORITY_NORMAL = "3";

    /** 分页类型_首页 */
    public static final String KEY_TURN_PAGE_TYPE_FIRST = "first";
    /** 分页类型_前页 */
    public static final String KEY_TURN_PAGE_TYPE_PREV = "prev";
    /** 分页类型_次页 */
    public static final String KEY_TURN_PAGE_TYPE_NEXT = "next";
    /** 分页类型_末页 */
    public static final String KEY_TURN_PAGE_TYPE_LAST = "last";
    /** 分页类型_指定页 */
    public static final String KEY_TURN_PAGE_TYPE_SPEC = "spec";

    /** 选择项目_全体银行（KEY） */
    public static final String OPTION_KEY_ALL_BANK = "000";

    /** 验证错误信息 key DB操作错误*/
    public static final String KEY_DB_ERROR = "DBError";
    /** 验证错误信息 key DB操作错误(指定的记录不存在)*/
    public static final String KEY_DB_ERROR_NO_TARGET_DATA = "DBErrorNoTargetData";

    /** 验证错误信息 key 登录用户信息无效*/
    public static final String KEY_NONE_LOGIN_INFO = "noneLoginInfo";
    /** 验证错误信息 key 用户名为空*/
    public static final String KEY_USER_NAME_NULL = "userNameNull";
    /** 验证错误信息 key 密码为空 */
    public static final String KEY_USER_PASSWORD_NULL = "userPasswordNull";
    /** 验证错误信息 key 密码不正确*/
    public static final String KEY_USER_PASSWORD_ERROR = "userPasswordError";

    /** 验证错误信息 key 会话超时*/
    public static final String KEY_SESSION_TIMEOUT_ERROR = "sessionTimeOutError";
    /** 验证错误信息 key 不明异常*/
    public static final String KEY_UNKNOWN_ERROR = "unknownError";

}
