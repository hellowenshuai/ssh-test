package com.fuji.common;

/**
 * 翻页处理
 *
 */
public class PagerHelp {

    /**
     * 翻页处理器取得
     *
     * @param currentPage
     *            当前页码
     * @param turnPageType
     *            翻页类型
     * @param totalRows
     *            记录总行数
     * @return 翻页处理器
     */
    public static Pager getPager(String currentPage, String turnPageType,
            int totalRows) {

        Pager pager = new Pager(totalRows);

        if (CommonUtil.isEmpty(currentPage)) {
            pager.init();
            return pager;
        } else {
            pager.setCurrentPage(CommonUtil.parseInt(currentPage));
        }

        if (!CommonUtil.isEmpty(turnPageType)) {
            if ((Constants.KEY_TURN_PAGE_TYPE_FIRST).equals(turnPageType)) {
                pager.first();
            } else if ((Constants.KEY_TURN_PAGE_TYPE_PREV).equals(turnPageType)) {
                pager.previous();
            } else if ((Constants.KEY_TURN_PAGE_TYPE_NEXT).equals(turnPageType)) {
                pager.next();
            } else if ((Constants.KEY_TURN_PAGE_TYPE_LAST).equals(turnPageType)) {
                pager.last();
            } else if ((Constants.KEY_TURN_PAGE_TYPE_SPEC).equals(turnPageType)) {
                pager.refresh(CommonUtil.parseInt(currentPage));
            }
        }

        return pager;

    }

}
