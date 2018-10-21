package com.fuji.common;

/**
 * 翻页信息
 *
 */
public class Pager {

    /** 总行数 */
    private int totalRows;
    /** 每页显示行数 */
    private int pageSize;
    /** 当前页号 */
    private int currentPage;
    /** 总页数 */
    private int totalPages;
    /** 当前页在数据集中的起始行 */
    private int startRow;

    /** 一页默认表示行数 */
    public static int DEFAULT_PAGE_SIZE = 6;

    public Pager() {
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public Pager(int totalRows, int currentPage) {
        this.totalRows = totalRows;
        this.currentPage = currentPage;
        this.pageSize = DEFAULT_PAGE_SIZE;
        calculateTotalPages();
    }

    public Pager(int totalRows) {
        this.totalRows = totalRows;
        this.pageSize = DEFAULT_PAGE_SIZE;
        calculateTotalPages();
    }


    /**
     * 计算总页数
     */
    private void calculateTotalPages() {

        int remainder = totalRows % pageSize;

        if (0 == remainder) {
            totalPages = totalRows / pageSize;
        } else {
            totalPages = totalRows / pageSize + 1;
        }

    }

    /**
     * 初始化处理
     */
    public void init() {
        first();
    }

    /**
     * 首页处理
     */
    public void first() {
        currentPage = 1;
        startRow = 0;
    }

    /**
     * 前页处理
     */
    public void previous() {

        if (currentPage > 1) {
            currentPage--;
            startRow = (currentPage - 1) * pageSize;
        }

    }

    /**
     * 次页处理
     */
    public void next() {

        if (currentPage < totalPages) {
            currentPage++;
            startRow = (currentPage - 1) * pageSize;
        }
    }

    /**
     * 末页处理
     */
    public void last() {
        currentPage = totalPages;
        startRow = (currentPage - 1) * pageSize;
    }

    /**
     * 指定页处理
     */
    public void refresh(int targetPage) {

        if (targetPage < 1) {
            first();
        } else if (targetPage > totalPages) {
            last();
        } else {
            currentPage = targetPage;
            startRow = (currentPage - 1) * pageSize;
        }
    }

    /**
     * 取得totalRows
     * @return totalRows
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * 设定totalRows
     * @param int totalRows
     */
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * 取得pageSize
     * @return pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设定pageSize
     * @param int pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 取得currentPage
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设定currentPage
     * @param int currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 取得totalPages
     * @return totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * 设定totalPages
     * @param int totalPages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 取得startRow
     * @return startRow
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * 设定startRow
     * @param int startRow
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    };

}
