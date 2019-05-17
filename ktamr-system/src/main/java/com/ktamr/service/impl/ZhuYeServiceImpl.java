package com.ktamr.service.impl;

import com.ktamr.domain.zhuYe;
import com.ktamr.mapper.ZhuYeMapper;
import com.ktamr.service.ZhuYeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    /**
     *  1、正常表计数
     * @return
     */
    @Override
    public Integer meterStateCount03() {
        Integer meterStateCount03 = zhuYeMapper.meterStateCount03();
        if(meterStateCount03!=null){
            return meterStateCount03;
        }
        return null;
    }

    /**
     * 2、异常状态计数
     * @return
     */
    @Override
    public Integer meterStateCount09() {
        Integer meterStateCount09 = zhuYeMapper.meterStateCount09();
        if(meterStateCount09!=null){
            return meterStateCount09;
        }
        return null;
    }

    /**
     *  3、无返回数据计数
     * @return
     */
    @Override
    public Integer meterStateCount01() {
        Integer meterStateCount01 = zhuYeMapper.meterStateCount01();
        if(meterStateCount01!=null){
            return meterStateCount01;
        }
        return null;
    }

    /**
     * 4、用量异常计数
     * @return
     */
    @Override
    public Integer meterStateCount10() {
        Integer meterStateCount10 = zhuYeMapper.meterStateCount10();
        if(meterStateCount10!=null){
            return meterStateCount10;
        }
        return null;
    }

    /**
     * 5、开阀状态计数
     * @return
     */
    @Override
    public Integer meterStateCount11() {
        Integer meterStateCount11 = zhuYeMapper.meterStateCount11();
        if(meterStateCount11!=null){
            return meterStateCount11;
        }
        return null;
    }

    /**
     * 6、其他状态表计数
     * @return
     */
    @Override
    public List<zhuYe> meterStateCountQiTa() {
        List<zhuYe> meterStateCountQiTa = zhuYeMapper.meterStateCountQiTa();
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
    public List<zhuYe> meterStateCountJiZhongQi() {
        List<zhuYe> meterStateCountJiZhongQi = zhuYeMapper.meterStateCountJiZhongQi();
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
    public Integer meterStateCountCaiJiQi1() {
        Integer meterStateCountCaiJiQi1 = zhuYeMapper.meterStateCountCaiJiQi1();
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
    public Integer meterStateCountCaiJiQi2() {
        Integer meterStateCountCaiJiQi2 = zhuYeMapper.meterStateCountCaiJiQi2();
        if(meterStateCountCaiJiQi2!=null){
            return meterStateCountCaiJiQi2;
        }
        return null;
    }
}
