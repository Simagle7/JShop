package cn.jshop.common.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
public class BizData4Page<T> implements Serializable {
    private int page = 1;
    private int total = 0;
    private int pageSize = 10;
    private int records = 0;
    private int offset = 0;
    private int endOffset = 0;
    private List<T> rows;
    private Map<String, Object> conditions = new HashMap<String, Object>();
    private Map<List, Object> userData;

    public BizData4Page(){}

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getEndOffset() {
        return endOffset;
    }

    public void setEndOffset(int endOffset) {
        this.endOffset = endOffset;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getConditions() {
        return conditions;
    }

    public void setConditions(Map<String, Object> conditions) {
        this.conditions = conditions;
    }

    public Map<List, Object> getUserData() {
        return userData;
    }

    public void setUserData(Map<List, Object> userData) {
        this.userData = userData;
    }
}
