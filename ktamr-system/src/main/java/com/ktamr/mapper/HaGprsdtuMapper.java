package com.ktamr.mapper;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaGprsdtu;

import java.util.List;
import java.util.Map;

public interface HaGprsdtuMapper {

    public List<Map<String,Object>> selectAllGprsdtuAndCount(ParameterInfo parms);

    List<HaGprsdtu> HaGprsdtuList(HaGprsdtu haGprsdtu);

    Integer addHaGprsdtu(HaGprsdtu haGprsdtu);

    Integer updateHaGprsdtu(HaGprsdtu haGprsdtu);

    Integer deleteHaGprsdtu(HaGprsdtu haGprsdtu);
}
