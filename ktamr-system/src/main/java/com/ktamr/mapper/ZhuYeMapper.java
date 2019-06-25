package com.ktamr.mapper;

import com.ktamr.common.core.domain.BaseEntity;
import com.ktamr.domain.zhuYe;

import java.util.List;
import java.util.Map;

/**
 * 定义一个主页查询
 */
public interface ZhuYeMapper {
    /**
     * 小区总数
     * @return
     */
    public Integer areaCount(BaseEntity baseEntity);

    /**
     * 表档案总数
     * @return
     */
    public Integer meterCount(BaseEntity baseEntity);

    /**
     * 不良表总数
     * @return
     */
    public Integer notOkCount(BaseEntity baseEntity);

    /**
     * 失联表总数
     * @return
     */
    public Integer notConnectedCount(BaseEntity baseEntity);

    /**
     * 用户资料总数
     * @return
     */
    public Integer userCount(BaseEntity baseEntity);

    /**
     * 集采器总数
     * @return
     */
    public Integer ccentorCount(BaseEntity baseEntity);

    /**
     * 集中器总数
     * @return
     */
    public Integer centorCount(BaseEntity baseEntity);

    /**
     * 采集器总数
     * @return
     */
    public Integer collectorCount(BaseEntity baseEntity);


    //《表状态统计begin》

    /**
     * 开挂板
     * @return
     */
    Map<String, Object> getMeterStateCount(BaseEntity baseEntity);


    /**
     * 6、其他状态表计数
     * @return
     */
    public List<zhuYe> meterStateCountQiTa(BaseEntity baseEntity);

    /**
     *集中器状态统计
     * @return
     */
    public List<zhuYe> meterStateCountJiZhongQi(BaseEntity baseEntity);

    /**
     *采集器统计1
     * @return
     */
    public Integer meterStateCountCaiJiQi1(BaseEntity baseEntity);

    /**
     *采集器统计2
     * @return
     */
    public Integer meterStateCountCaiJiQi2(BaseEntity baseEntity);





    //《表状态统计end》


}
