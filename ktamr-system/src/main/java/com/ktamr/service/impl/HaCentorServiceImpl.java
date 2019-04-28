package com.ktamr.service.impl;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaCentor;
import com.ktamr.mapper.HaCentorMapper;
import com.ktamr.service.HaCentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HaCentorServiceImpl implements HaCentorService {

    @Autowired
    private HaCentorMapper haCentorMapper;

    @Override
    public List<Map<String,Object>> selectAllCentorzAndCount(HaCentor parms) {
        return haCentorMapper.selectAllCentorzAndCount(parms);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorzQueryIdAndCount(ParameterInfo parms) {
        return haCentorMapper.selectAllCentorzQueryIdAndCount(parms);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorcAndCount(ParameterInfo parms) {
        return haCentorMapper.selectAllCentorcAndCount(parms);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorzByIdAndCount(ParameterInfo parms) {
        return haCentorMapper.selectAllCentorzByIdAndCount(parms);
    }

    @Override
    public List<Map<String, Object>> selectAllCentorHandAndCount(ParameterInfo parms) {
        return haCentorMapper.selectAllCentorHandAndCount(parms);
    }

    @Override
    public List<HaCentor> selectCentor(HaCentor haCentor) {
        return haCentorMapper.selectCentor(haCentor);
    }

    public List<HaCentor> HaCentorList(HaCentor haCentor) {
        return haCentorMapper.HaCentorList(haCentor);
    }

    public Integer addHaCentor(HaCentor haCentor) {
        return haCentorMapper.addHaCentor(haCentor);
    }

    public Integer updateHaCentor(HaCentor haCentor) {
        return haCentorMapper.updateHaCentor(haCentor);
    }

    public Integer deleteHaCentor(HaCentor haCentor) {
        return haCentorMapper.deleteHaCentor(haCentor);
    }
}
