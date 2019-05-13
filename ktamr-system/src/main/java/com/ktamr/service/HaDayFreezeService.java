package com.ktamr.service;

import com.ktamr.domain.HaDayfreeze;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;

import java.util.List;

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
}
