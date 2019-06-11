package com.ktamr.service;

import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaMonfreeze;

import java.util.List;
import java.util.Map;

public interface HaMonFreezeService {

    public Integer selectMonFreezeMeterIdCount(HaMeter haMeter);

    public Integer updateMonFreeze(HaMeter haMeter);

    public Integer insertMonFreeze(HaMeter haMeter);

    /**
     * 查询月冻结抄收记录表信息
     * @param parms Map参数
     * @return 返回泛型集合
     */
    public List<HaMonfreeze> selectAllMonfreeze(Map<String,Object> parms);

    Integer delHaMonFreeze(Integer meterId);
}
