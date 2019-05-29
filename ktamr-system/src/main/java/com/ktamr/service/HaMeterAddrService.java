package com.ktamr.service;

import com.ktamr.domain.HaMeterAddr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaMeterAddrService {

    /**
     * 查询ha_meter_addr表并且向左连接两表
     * @param cmdId 条件id
     * @return 返回泛型集合HaMeterAddr类
     */
    public List<HaMeterAddr> selectMeterAddrLeftJoinTow(Integer cmdId);

    /**
     * 查询ha_meter_addr表并且向左连接两表
     * @param cmdId 条件id
     * @return 返回泛型集合HaMeterAddr类
     */
    public List<HaMeterAddr> selectMeterAddrLeftJoinTow2(@Param("cmdId") Integer cmdId);
}
