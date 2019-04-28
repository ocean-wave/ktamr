package com.ktamr.service;

import com.ktamr.domain.HaMeter;

public interface HaMonFreezeService {

    public Integer selectMonFreezeMeterIdCount(HaMeter haMeter);

    public Integer updateMonFreeze(HaMeter haMeter);

    public Integer insertMonFreeze(HaMeter haMeter);
}
