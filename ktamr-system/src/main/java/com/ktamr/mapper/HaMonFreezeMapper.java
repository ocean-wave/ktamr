package com.ktamr.mapper;

import com.ktamr.domain.HaMeter;

public interface HaMonFreezeMapper {

    public Integer selectMonFreezeMeterIdCount(HaMeter haMeter);

    public Integer updateMonFreeze(HaMeter haMeter);

    public Integer insertMonFreeze(HaMeter haMeter);
}
