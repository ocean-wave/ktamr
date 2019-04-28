package com.ktamr.util;

import java.util.List;

public class GridData<T>  {

    /**
     * 每页显示记录数
     */
    private int total;
    /**
     * 当前第几页
     */
    private int page;
    /**
     * 总记录数
     */
    private int records;

    private Pagination pagination;

    public GridData() {

    }

    public GridData(Pagination _pagination) {
        this.pagination = _pagination;
        this.total = _pagination.getTotal();
        this.page = _pagination.getPage();
        this.records = _pagination.getRecords();
    }
    public  void setTotal(int _total) {
        this.total = _total;

    }
    public  int getTotal() {
        return this.total;
    }

    public void setPage(int _page) {
        this.page = _page;
    }

    public  int getPage() {
        return this.page;
    }

    public void setRecords(int _records) {
        this.records = _records;
    }

    public  int getRecords() {
        return this.records;
    }

    public Pagination getPagination() {
        return this.pagination;
    }

     /**
     * 要展示（包装）的实体对象集合
     */
    private List<T> rows;

    public void setRows(List<T> _rows) {
        this.rows = _rows;
    }

    public List<T> getRows() {
        return this.rows;
    }




}