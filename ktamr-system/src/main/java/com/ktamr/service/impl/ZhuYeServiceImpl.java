package com.ktamr.service.impl;

import com.ktamr.common.core.domain.BaseEntity;
import com.ktamr.domain.zhuYe;
import com.ktamr.mapper.ZhuYeMapper;
import com.ktamr.service.ZhuYeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Integer areaCount(BaseEntity baseEntity) {
        Integer areaCount = zhuYeMapper.areaCount(baseEntity);
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
    public Integer meterCount(BaseEntity baseEntity) {
        Integer meterCount = zhuYeMapper.meterCount(baseEntity);
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
    public Integer notOkCount(BaseEntity baseEntity) {
        Integer notOkCount = zhuYeMapper.notOkCount(baseEntity);
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
    public Integer notConnectedCount(BaseEntity baseEntity) {
        Integer notConnectedCount = zhuYeMapper.notConnectedCount(baseEntity);
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
    public Integer userCount(BaseEntity baseEntity) {
        Integer userCount = zhuYeMapper.userCount(baseEntity);
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
    public Integer ccentorCount(BaseEntity baseEntity) {
        Integer ccentorCount = zhuYeMapper.ccentorCount(baseEntity);
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
    public Integer centorCount(BaseEntity baseEntity) {
        Integer centorCount = zhuYeMapper.centorCount(baseEntity);
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
    public Integer collectorCount(BaseEntity baseEntity) {
        Integer collectorCount = zhuYeMapper.collectorCount(baseEntity);
        if(collectorCount!=null){
            return collectorCount;
        }
        return null;
    }

    /**
     * 开挂板
     * @return
     */
    @Override
    public Map<String, Object> getMeterStateCount(BaseEntity baseEntity) {
        Map<String, Object> map = zhuYeMapper.getMeterStateCount(baseEntity);
        if(map!=null){
            return map;
        }
        return null;
    }



    /**
     * 6、其他状态表计数
     * @return
     */
    @Override
    public List<zhuYe> meterStateCountQiTa(BaseEntity baseEntity) {
        List<zhuYe> meterStateCountQiTa = zhuYeMapper.meterStateCountQiTa(baseEntity);
        if(meterStateCountQiTa!=null){
            return meterStateCountQiTa;
        }
        return null;
    }

    /**
     * 集中器状态统计
     * @return
     */
    @Override
    public List<zhuYe> meterStateCountJiZhongQi(BaseEntity baseEntity) {
        List<zhuYe> meterStateCountJiZhongQi = zhuYeMapper.meterStateCountJiZhongQi(baseEntity);
        if(meterStateCountJiZhongQi!=null){
            return meterStateCountJiZhongQi;
        }
        return null;
    }

    /**
     * 采集器统计1
     * @return
     */
    @Override
    public Integer meterStateCountCaiJiQi1(BaseEntity baseEntity) {
        Integer meterStateCountCaiJiQi1 = zhuYeMapper.meterStateCountCaiJiQi1(baseEntity);
        if(meterStateCountCaiJiQi1!=null){
            return meterStateCountCaiJiQi1;
        }
        return null;
    }

    /**
     * 采集器统计2
     * @return
     */
    @Override
    public Integer meterStateCountCaiJiQi2(BaseEntity baseEntity) {
        Integer meterStateCountCaiJiQi2 = zhuYeMapper.meterStateCountCaiJiQi2(baseEntity);
        if(meterStateCountCaiJiQi2!=null){
            return meterStateCountCaiJiQi2;
        }
        return null;
    }
}
