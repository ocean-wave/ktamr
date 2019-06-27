package com.ktamr.common.core.domain;

import com.ktamr.common.utils.ServletUtils;
import com.ktamr.common.utils.StringUtils;
import com.ktamr.common.utils.sql.SqlCondition;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Entity基类
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1757268941502216661L;
    /**
     * 创建时间bangbangbang
     */
    @JsonFormat(pattern = " yyyy-MM-dd HH:mm:ss ")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = " yyyy-MM-dd HH:mm:ss ")
    private Date modifyTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 修改者
     */
    private String modifyBy;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    private String multipleConditions;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getMultipleConditions() {
        if (params == null) {
            params = new HashMap<>();
        }
        String str = params.get("multipleConditions") != null ? params.get("multipleConditions").toString() : null;
        if (StringUtils.isEmpty(str)) {
            this.multipleConditions = SqlCondition.getMultipleConditions();
            params.put("multipleConditions", multipleConditions);
        }
        return str == null ? this.multipleConditions : str;
    }

    public void setMultipleConditions(String multipleConditions) {
        this.multipleConditions = multipleConditions;
    }
}
