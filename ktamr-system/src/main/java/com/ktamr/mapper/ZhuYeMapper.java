package com.ktamr.mapper;

import com.ktamr.domain.zhuYe;

import java.util.List;

/**
 * 定义一个主页查询
 */
public interface ZhuYeMapper {
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
     * 1、正常表计数
     * @return
     */
    public Integer meterStateCount03();

    /**
     *2、异常状态计数
     * @return
     */
    public Integer meterStateCount09();

    /**
     *3、无返回数据计数
     * @return
     */
    public Integer meterStateCount01();

    /**
     *4、用量异常计数
     * @return
     */
    public Integer meterStateCount10();

    /**
     *5、开阀状态计数
     * @return
     */
    public Integer meterStateCount11();

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
