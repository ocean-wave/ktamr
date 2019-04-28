package com.ktamr.common.core.page;

import java.util.Map;

public class Page {
    private Integer page;  //第几页
    private Integer rows;   //显示的条数
    private Integer total;
    private Integer records;
    private Map<String,Object> parms;

    public Page(Map<String, Object> parms,Integer records) {
        this.setRecords(records);
        this.setPage(Integer.parseInt(parms.get("page").toString()));
        this.setTotal(Integer.parseInt(parms.get("rows").toString()));
        this.setRows(Integer.parseInt(parms.get("rows").toString()));
        parms.put("rows",this.getRows());
    }

    public Map<String, Object> getParms() {
        return parms;
    }

    public void setParms(Map<String, Object> parms) {
        this.parms = parms;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if(this.records!= null && this.records > 1) {
            this.page = page;
        }else{
            this.page = 1;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if( this.records != 0  && this.page == (this.records / rows) + 1) {
            this.rows = this.records - (rows * (this.page - 1));
        }else{
            this.rows = rows;
        }
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer rows) {
        if(this.records != 0 && this.records % rows == 0) {
            this.total =  this.records  / rows;
        }else{
            this.total =  this.records / rows + 1;
        }
    }
}
