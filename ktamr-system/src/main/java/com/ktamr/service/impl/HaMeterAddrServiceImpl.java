package com.ktamr.service.impl;

import com.ktamr.domain.HaMeterAddr;
import com.ktamr.mapper.HaMeterAddrMapper;
import com.ktamr.service.HaMeterAddrService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HaMeterAddrServiceImpl implements HaMeterAddrService {

    private HaMeterAddrMapper haMeterAddrMapper;

    /**
     * 查询ha_meter_addr表并且向左连接两表
     * @param cmdId 条件id
     * @return 返回泛型集合HaMeterAddr类
     */
    @Override
    public List<HaMeterAddr> selectMeterAddrLeftJoinTow(Integer cmdId) {
        return haMeterAddrMapper.selectMeterAddrLeftJoinTow(cmdId);
    }
}
