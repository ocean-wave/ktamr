package com.ktamr.service.impl;

import com.ktamr.domain.HaReplacerecords;
import com.ktamr.mapper.HaReplaceRecordsMapper;
import com.ktamr.service.HaReplaceRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 换表记录表实现类
 */
@Service
public class HaReplaceRecordsServiceImpl implements HaReplaceRecordsService {

    /**
     * 注入Mapper
     */
    @Autowired
    private HaReplaceRecordsMapper haReplaceRecordsMapper;

    /**
     * 查询换表记录表信息
     * @param haReplacerecords 对象参数
     * @return 返回泛型对象集合
     */
    @Override
    public List<HaReplacerecords> selectReplace(HaReplacerecords haReplacerecords) {
        return haReplaceRecordsMapper.selectReplace(haReplacerecords);
    }
}
