package com.ktamr.service;

import com.ktamr.domain.HaFreeze;

import java.util.List;

public interface HaFreezeService {
    /**
     *点击费用结算所做的步骤1
     * @param haFreeze
     * @return
     */
    public  Integer insertHaFreeze11(HaFreeze haFreeze);

    /**
     *点击费用结算所做的步骤2
     * @param haFreeze
     * @return
     */
    public  Integer insertHaFreeze12(HaFreeze haFreeze);

    /**
     * 2、阶梯费用计算 点击费用结算所做的步骤3
     * @param haFreeze
     * @return
     */
    public Integer  BinsertHaFreeze2(HaFreeze haFreeze);

    /**
     * 3、生成新缴费单（对相应的用户）点击费用结算所做的步骤3
     * @param haFreeze
     * @return
     */
    public Integer BinsertHaFreeze3(HaFreeze haFreeze);

    /**
     * 4、取消未完成结算的缴费单 点击费用结算所做的步骤4
     * @param haFreeze
     * @return
     */
    public Integer BinsertHaFreeze41(HaFreeze haFreeze);

    /**
     * 修改之前未完成结算缴费单状态 点击费用结算所做的步骤4.2
     * @param haFreeze
     * @return
     */
    public Integer BinsertHaFreeze42(HaFreeze haFreeze);

    /**
     *修改ha_custom 上次的 billid 点击费用结算所做的步骤4.3
     * @param haFreeze
     * @return
     */
    public Integer BinsertHaFreeze43(HaFreeze haFreeze);


    /**
     *在ha_monthBTime表中加入结算查询时间区间的起始时间 点击费用结算所做的步骤5.1
     * @param haFreeze
     * @return
     */
    public Integer BinsertHaFreeze51(HaFreeze haFreeze);

    /**
     *点击费用结算所做的步骤5.2 即最后步骤
     * @param haFreeze
     * @return
     */
    public Integer BinsertHaFreeze52(HaFreeze haFreeze);

    /**
     * 点击打印缴费单时进行查询2
     * @param haFreeze
     * @return
     */
    public HaFreeze BselectPritJiaoFeiDan2(HaFreeze haFreeze);

}
