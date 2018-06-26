package com.cdg.common.model;

import java.io.Serializable;
import java.util.List;

/**
  * @description 封装返回列表

  * @author zhenghao
*/

public class ResultList implements Serializable{

    private static final long serialVersionUID = 1L;

    private long total;
    
    private List rows;
    
    private String cacheQryId;
    
    public ResultList(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
    
    public ResultList(long total, List rows, String cacheQryId) {
        this.total = total;
        this.rows = rows;
        this.cacheQryId = cacheQryId;
    }
    

    public String getCacheQryId() {
        return cacheQryId;
    }

    public void setCacheQryId(String cacheQryId) {
        this.cacheQryId = cacheQryId;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
    
}