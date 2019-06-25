package com.ktamr.service;

import com.ktamr.domain.zhuYe;

import java.util.List;
import java.util.Map;

/**
 * 主页查询的service层
 */
public interface ZhuYeService {

    /**
     * 小区总数
     * @return
     */
    public Integer areaCount();

    /**
     * 表档案总数
     * @return
     */
    public Integer meterCount();

    /**
     * 不良表总数
     * @return
     */
    public Integer notOkCount();

    /**
     * 失联表总数
     * @return
     */
    public Integer notConnectedCount();

    /**
     * 用户资料总数
     * @return
     */
    public Integer userCount();

    /**
     * 集采器总数
     * @return
     */
    public Integer ccentorCount();

    /**
     * 集中器总数
     * @return
     */
    public Integer centorCount();

    /**
     * 采集器总数
     * @return
     */
    public Integer collectorCount();



    //《表状态统计begin》

    /**
     * 开挂板
     * @return
     */
    Map<String, Object> getMeterStateCount(zhuYe zhuYe);

    /**
     * 6、其他状态表计数
     * @return
     */
    public List<zhuYe> meterStateCountQiTa();

    /**
     *集中器状态统计
     * @return
     */
    public List<zhuYe> meterStateCountJiZhongQi();

    /**
     *采集器统计1
     * @return
     */
    public Integer meterStateCountCaiJiQi1();

    /**
     *采集器统计2
     * @return
     */
    public Integer meterStateCountCaiJiQi2();





    //《表状态统计end》
}
