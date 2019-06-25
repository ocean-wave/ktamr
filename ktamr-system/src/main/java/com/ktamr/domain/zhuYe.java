package com.ktamr.domain;

import com.ktamr.common.core.domain.BaseEntity;

/**
 * 定义主页别名
 */
public class zhuYe extends BaseEntity {
    private String state;//状态
    private Integer total;//总数



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
