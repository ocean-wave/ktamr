package com.ktamr.common.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ktamr.common.utils.ServletUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *Entity基类
 */
public class BaseEntity implements Serializable{

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

    /** 请求参数 */
    private Map<String, Object> params;

    private Map<String,Object[]> paramsArray;

    private Map<String,Object> resultParams;

    public BaseEntity() {
        if(params == null){
            params = new HashMap<>();
        }
        params.put("operatorRgnType",ServletUtils.getSession().getAttribute("operatorRgnType"));
        params.put("rgnStr",ServletUtils.getSession().getAttribute("rgnStr"));
        params.put("areaNo",ServletUtils.getSession().getAttribute("areaNo"));
        params.put("operatorCompanyId",ServletUtils.getSession().getAttribute("operatorCompanyId"));
        params.put("operatorCode",ServletUtils.getSession().getAttribute("operatorCode"));
        params.put("operatorLevel",ServletUtils.getSession().getAttribute("operatorLevel"));
    }

    public Map<String, Object[]> getParamsArray() {
        return paramsArray;
    }

    public void setParamsArray(Map<String, Object[]> paramsArray) {
        this.paramsArray = paramsArray;
    }

    public Map<String, Object> getResultParams() {
        return resultParams;
    }

    public void setResultParams(Map<String, Object> resultParams) {
        this.resultParams = resultParams;
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

    public Map<String, Object> getParams()
    {
        if (params == null)
        {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }

}
