package com.ktamr.service;

import com.ktamr.domain.HaMeter;

public interface HaDayFreezeService {

    public Integer selectDayFreezeMeterIdCount(HaMeter haMeter);

    public Integer updateDayFreeze(HaMeter haMeter);

    public Integer insertDayFreeze(HaMeter haMeter);
}
