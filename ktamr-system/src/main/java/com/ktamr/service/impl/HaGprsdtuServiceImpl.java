package com.ktamr.service.impl;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaGprsdtu;
import com.ktamr.mapper.HaGprsdtuMapper;
import com.ktamr.service.HaGprsdtuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HaGprsdtuServiceImpl implements HaGprsdtuService {

    @Autowired
    private HaGprsdtuMapper haGprsdtuMapper;

    @Override
    public List<Map<String, Object>> selectAllGprsdtuAndCount(ParameterInfo parms) {
        return haGprsdtuMapper.selectAllGprsdtuAndCount(parms);
    }

    public List<HaGprsdtu> HaGprsdtuList(HaGprsdtu haGprsdtu) {
        return haGprsdtuMapper.HaGprsdtuList(haGprsdtu);
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
}
