package com.ktamr.service.impl;

import com.ktamr.domain.HaGprsdtu;
import com.ktamr.mapper.HaGprsdtuMapper;
import com.ktamr.service.HaGprsdtuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备表实现类
 */
@Service
public class HaGprsdtuServiceImpl implements HaGprsdtuService {

    /**
     * 注入HaGprsdtuMapper
     */
    @Autowired
    private HaGprsdtuMapper haGprsdtuMapper;

    /**
     * 查询DTU信息并且统计下属集采器数目
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    @Override
    public List<HaGprsdtu> selectAllGprsdtuAndCount(HaGprsdtu parms) {
        return haGprsdtuMapper.selectAllGprsdtuAndCount(parms);
    }

    public List<HaGprsdtu> HaGprsdtuList(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.HaGprsdtuList(haGprsdtu);
    }

    @Override
    public HaGprsdtu updateByIdHaGprsdtu(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.updateByIdHaGprsdtu(haGprsdtu);
    }

    @Override
    public Integer HaGprsdtuCount(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.HaGprsdtuCount(haGprsdtu);
    }

    public Integer addHaGprsdtu(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.addHaGprsdtu(haGprsdtu);
    }

    public Integer updateHaGprsdtu(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.updateHaGprsdtu(haGprsdtu);
    }

    public Integer deleteHaGprsdtu(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.deleteHaGprsdtu(haGprsdtu);
    }

    @Override
    public Integer addingCellValidation(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.addingCellValidation(haGprsdtu);
    }
}
