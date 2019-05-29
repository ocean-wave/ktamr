package com.ktamr.service;

import com.ktamr.domain.HaDayfreeze;
import com.ktamr.domain.HaMeter;

import java.util.List;
import java.util.Map;

public interface HaDayFreezeService {

    public Integer selectDayFreezeMeterIdCount(HaMeter haMeter);

    public Integer updateDayFreeze(HaMeter haMeter);

    public Integer insertDayFreeze(HaMeter haMeter);

    /**
     * 查询冻结数据
     * @param params 对象参数
     * @return 返回泛型对象集合
     */
    public List<HaDayfreeze> selectFreeze(HaDayfreeze params);

    /**
     * 查询冻结表信息
     * @param params Map参数
     * @return 返回泛型集合
     */
    public List<HaDayfreeze> selectAllDayfreeze(Map<String,Object> params);
}
