package com.fuji.common;

import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * 通用工具类
 *
 */
public class CommonUtil {

    /** 日志 */
    private static Logger sLogger = (Logger) LogManager
            .getLogger(CommonUtil.class);

    /** 消息属性 */
    private static Properties sMessagePropertie = PropertyFactorys
            .getMessageProperties();


    /**
     * 空值判断
     *
     * @param obj
     *            对象
     * @return <tt>true</tt> if this object contains no elements
     */
    public static boolean isEmpty(Object obj) {

        if (null == obj) {
            return true;
        } else if (obj instanceof String) {
            if ("".equals(((String) obj).trim())) {
                return true;
            }
        } else if (obj instanceof List) {
            final List<?> list = (List<?>) obj;
            return list.isEmpty();
        }

        return false;
    }

    /**
     * 文字列转化成数字
     *
     * @param str
     * @return
     */
    public static int parseInt(String str) {
        int returnInt = 0;
        try {
            returnInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            sLogger.error(e.getStackTrace());
        }
        return returnInt;
    }

    /**
     * 信息内容取得
     *
     * @param strCode
     * @param args
     * @return
     */
    public static String getMessage(String strCode, Object[] args) {

        final String str = sMessagePropertie.getProperty(strCode);
        if (isEmpty(str)) {
            return "undefind";
        }
        return MessageFormat.format(str, args);
    }

    /**
     * 信息内容取得
     *
     * @param strCode
     * @return
     */
    public static String getMessage(String strCode) {

        final String str = sMessagePropertie.getProperty(strCode);
        if (isEmpty(str)) {
            return "undefind";
        }
        return str;
    }

    /**
     * 银行ID的补正处理
     *
     * @param bankId
     *            银行ID
     * @return 补正后银行ID
     */
    public static String fixBankIdForSearch(String bankId) {
        // SQL检索用银行ID
        String bankIdSql;
        // 全体银行选择的场合
        if (Constants.OPTION_KEY_ALL_BANK.equals(bankId)) {
            bankIdSql = null;
        } else {
            bankIdSql = bankId;
        }

        return bankIdSql;
    }

    /**
    * SQL文里追加where或and关键字
    * @param hasWhere
    * @param sb
    * @return
    */
   public static boolean appendWhereOrAndSqlMark(boolean hasWhere, StringBuffer sb) {

       if (hasWhere) {
           sb.append(" and ");
       } else {
           sb.append(" where ");
           hasWhere = true;
       }

       return hasWhere;
   }


}
