package com.ktamr.mapper;

import com.ktamr.domain.HaMeter;

public interface HaDayFreezeMapper {

    public Integer selectDayFreezeMeterIdCount(HaMeter haMeter);

    public Integer updateDayFreeze(HaMeter haMeter);

    public Integer insertDayFreeze(HaMeter haMeter);
}
