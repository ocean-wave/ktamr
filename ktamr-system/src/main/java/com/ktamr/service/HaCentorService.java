package com.ktamr.service;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaCentor;

import java.util.List;
import java.util.Map;

public interface HaCentorService {

    public List<Map<String,Object>> selectAllCentorzAndCount(HaCentor parms);

    public List<Map<String,Object>> selectAllCentorzQueryIdAndCount(ParameterInfo parms);

    public List<Map<String,Object>> selectAllCentorcAndCount(ParameterInfo parms);

    public List<Map<String,Object>> selectAllCentorzByIdAndCount(ParameterInfo parms);

    public List<Map<String,Object>> selectAllCentorHandAndCount(ParameterInfo parms);

    public List<HaCentor> selectCentor(HaCentor haCentor);

    List<HaCentor> HaCentorList(HaCentor haCentor);

    Integer addHaCentor(HaCentor haCentor);

    Integer updateHaCentor(HaCentor haCentor);

    Integer deleteHaCentor(HaCentor haCentor);

}
