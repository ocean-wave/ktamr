package com.ktamr.service;

import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaMonfreeze;

import java.util.List;
import java.util.Map;

public interface HaMonFreezeService {

    public Integer insertMonFreeze(HaMeter haMeter);

    public Integer insertMonFreezeTwo(String importTime);

    public Integer updateMonFreeze(HaMeter haMeter);

    public Integer updateMonFreezeTwo(String importTime);

    Integer delHaMonFreeze(Integer meterId);

    public Integer selectMonFreezeMeterIdCount(HaMeter haMeter);


    /**
     * 查询月冻结抄收记录表信息
     * @param parms Map参数
     * @return 返回泛型集合
     */
    public List<HaMonfreeze> selectAllMonfreeze(Map<String,Object> parms);

}
