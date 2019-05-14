package com.ktamr.service.impl;

import com.ktamr.domain.HaDayfreeze;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HaRecords;
import com.ktamr.mapper.HaDayFreezeMapper;
import com.ktamr.service.HaDayFreezeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HaDayFreezeServiceImpl implements HaDayFreezeService {

    @Autowired
    private HaDayFreezeMapper haDayFreezeMapper;

    @Override
    public Integer selectDayFreezeMeterIdCount(HaMeter haMeter) {
        return haDayFreezeMapper.selectDayFreezeMeterIdCount(haMeter);
    }

    @Override
    public Integer updateDayFreeze(HaMeter haMeter) {
        return haDayFreezeMapper.updateDayFreeze(haMeter);
    }

    @Override
    public Integer insertDayFreeze(HaMeter haMeter) {
        return haDayFreezeMapper.insertDayFreeze(haMeter);
    }

    /**
     * 查询冻结数据
     * @param params 对象参数
     * @return 返回泛型对象集合
     */
    @Override
    public List<HaDayfreeze> selectFreeze(HaDayfreeze params) {
        return haDayFreezeMapper.selectFreeze(params);
    }

    /**
     * 查询冻结表信息
     * @param params Map参数
     * @return 返回泛型集合
     */
    @Override
    public List<HaDayfreeze> selectAllDayfreeze(Map<String,Object> params) {
        return haDayFreezeMapper.selectAllDayfreeze(params);
    }
}
