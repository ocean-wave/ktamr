package com.ktamr.service.impl;

import com.ktamr.mapper.ZhuYeMapper;
import com.ktamr.service.ZhuYeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 主页查询的实现层
 */
@Service
public class ZhuYeServiceImpl implements ZhuYeService {

    @Resource
    private ZhuYeMapper zhuYeMapper;

    /**
     *小区总数
     * @return
     */
    @Override
    public Integer areaCount() {
        Integer areaCount = zhuYeMapper.areaCount();
        if(areaCount!=null){
            return areaCount;
        }
        return null;
    }

    /**
     *表档案总数
     * @return
     */
    @Override
    public Integer meterCount() {
        Integer meterCount = zhuYeMapper.meterCount();
        if(meterCount!=null){
            return meterCount;
        }
        return null;
    }

    /**
     *不良表总数
     * @return
     */
    @Override
    public Integer notOkCount() {
        Integer notOkCount = zhuYeMapper.notOkCount();
        if(notOkCount!=null){
            return notOkCount;
        }
        return null;
    }

    /**
     *失联表总数
     * @return
     */
    @Override
    public Integer notConnectedCount() {
        Integer notConnectedCount = zhuYeMapper.notConnectedCount();
        if(notConnectedCount!=null){
            return notConnectedCount;
        }
        return null;
    }

    /**
     *用户资料总数
     * @return
     */
    @Override
    public Integer userCount() {
        Integer userCount = zhuYeMapper.userCount();
        if(userCount!=null){
            return userCount;
        }
        return null;
    }

    /**
     *集采器总数
     * @return
     */
    @Override
    public Integer ccentorCount() {
        Integer ccentorCount = zhuYeMapper.ccentorCount();
        if(ccentorCount!=null){
            return ccentorCount;
        }
        return null;
    }

    /**
     *集中器总数
     * @return
     */
    @Override
    public Integer centorCount() {
        Integer centorCount = zhuYeMapper.centorCount();
        if(centorCount!=null){
            return centorCount;
        }
        return null;
    }

    /**
     * 采集器总数
     * @return
     */
    @Override
    public Integer collectorCount() {
        Integer collectorCount = zhuYeMapper.collectorCount();
        if(collectorCount!=null){
            return collectorCount;
        }
        return null;
    }
}
