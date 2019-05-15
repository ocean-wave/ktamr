package com.ktamr.service;

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
}
