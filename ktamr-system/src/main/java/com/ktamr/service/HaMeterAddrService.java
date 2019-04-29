package com.ktamr.service;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaMeterAddr;

import java.util.List;
import java.util.Map;

public interface HaMeterAddrService {

    /**
     * 查询ha_meter_addr表并且向左连接两表
     * @param cmdId 条件id
     * @return 返回泛型集合HaMeterAddr类
     */
    public List<HaMeterAddr> selectMeterAddrLeftJoinTow(Integer cmdId);
}
