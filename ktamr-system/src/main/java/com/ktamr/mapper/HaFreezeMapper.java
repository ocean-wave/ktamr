package com.ktamr.mapper;

import com.ktamr.domain.HaFreeze;

public interface HaFreezeMapper {
    /**
     *点击费用结算所做的步骤1
     * @param haFreeze
     * @return
     */
    public  Integer insertHaFreeze1(HaFreeze haFreeze);

    /**
     *点击费用结算所做的步骤2
     * @param haFreeze
     * @return
     */
    public  Integer insertHaFreeze2(HaFreeze haFreeze);

}
