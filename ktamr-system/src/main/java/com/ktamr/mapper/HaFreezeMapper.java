package com.ktamr.mapper;

import com.ktamr.domain.HaFreeze;

public interface HaFreezeMapper {
    /**
     *点击费用结算所做的步骤1
     * @param haFreeze
     * @return
     */
    public  Integer BinsertHaFreeze1(HaFreeze haFreeze);

    /**
     *点击费用结算所做的步骤2
     * @param haFreeze
     * @return
     */
    public  Integer BinsertHaFreeze2(HaFreeze haFreeze);

}
