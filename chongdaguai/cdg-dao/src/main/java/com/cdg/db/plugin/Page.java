package com.cdg.db.plugin;

import java.io.Serializable;

/**
 * @author zhenghao
 * @description
 * @date 9:55 2017/10/24
 */

public final class Page implements Serializable {

    /**
     * 序列化标志
     */
    private static final long serialVersionUID = 1L;
    /**
     * 分页查询开始记录位置
     */
    private int begin;
    /**
     * 分页查看下结束位置.
     */
    private int end;
    /**
     * 当前页码
     */
    private int pageNo = 1;

    /**
     * 每页显示记录数
     */
    private int size = 10;

    /**
     * 查询结果总记录数
     */
    private int totalRecords;
    /**
     * 总页数
     */
    private int pageCount;

    /** 每页显示记录数 */
    private int limit = 10;

    /** 分页查询开始记录位置 */
    private int offset;
    //public Page() {
    //}

    /**
     * 设置页数，自动计算数据范围.
     *
     * @param
     * @param
     */
    public Page() {
        this.initNewPage(this.offset,this.limit);
    }
    /**
     * @param
     * @return
     * @description 前后台分页参数转换
     * @date 10:16 2017/10/24
     * @author zhenghao
     */
    public void initNewPage(int offset, int limit) {
        int newPageNo = 1;
        boolean flag= offset / limit < 1 ? true : false;
        int l = offset / limit;
        if (flag) {
            newPageNo = 1;
        } else {
            newPageNo = l + 1;
        }
        this.setPageParam(newPageNo, limit);
    }

    private void setPageParam(int pageNo, int size) {
        this.pageNo = pageNo;
        if (size == 0) {
            this.size = 20;
        } else {
            this.size = size;
        }

        pageNo = pageNo > 0 ? pageNo : 1;
        this.begin = this.size * (pageNo - 1);
        this.end = this.size * pageNo - 1;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.setPageParam(pageNo, size);
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
        if (this.size > 0) {
            this.pageCount = totalRecords / size;
            if (pageCount * size < totalRecords) {
                pageCount++;
            }
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.setPageParam(pageNo, size);
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getLimitBegin() {
        return (this.pageNo - 1) * this.size;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
        this.initNewPage(this.offset,this.limit);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("begin=").append(begin).append(", end=").append(end)
                .append(", length=").append(size).append(", totalRecords=").append(totalRecords).append(", pageNo=")
                .append(pageNo).append(", pageCount=").append(pageCount);
        return builder.toString();
    }

}