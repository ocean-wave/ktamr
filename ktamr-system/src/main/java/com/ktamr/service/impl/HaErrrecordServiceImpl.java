package com.ktamr.service.impl;

import com.ktamr.domain.HaErrrecord;
import com.ktamr.mapper.HaErrrecordMapper;
import com.ktamr.service.HaErrrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service实现层（HaErrrecordServiceImpl）
 */
@Service
public class HaErrrecordServiceImpl implements HaErrrecordService {

    /**
     * HaErrrecordMapper接口
     */
    @Autowired
    private HaErrrecordMapper haErrrecordMapper;

    /**
     * 查询ha_errRecord表并且向左连接四表
     * @param cmdId 条件id
     * @return返回泛型集合HaErrrecord类
     */
    @Override
    public List<HaErrrecord> selecErrrecordLeftJoinFour(Integer cmdId) {
        return haErrrecordMapper.selecErrrecordLeftJoinFour(cmdId);
    }
}
