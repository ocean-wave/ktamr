package com.ktamr.common.core.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageList {
    private List<?> map;
    private Map<String,Object> m;
    private Page p;

    public PageList() {
    }

    public PageList(List<?> map,Page p) {
        if(m==null){
            m = new HashMap<String, Object>();
        }
        m.put("records",p.getRecords());
        m.put("page",p.getPage());
        m.put("total",p.getTotal());
        m.put("rows", map);
        this.map = map;
    }

    public Page getP() {
        return p;
    }

    public void setP(Page p) {
        this.p = p;
    }

    public List<?> getMap() {
        return map;
    }

    public void setMap(List<?> map) {
        this.map = map;
    }

    public Map<String, Object> getM() {
        return m;
    }

    public void setM(Map<String, Object> m) {
        this.m = m;
    }
}
