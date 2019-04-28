package com.ktamr.mapper;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;

import java.util.List;
import java.util.Map;

public interface HaRecordsMapper {

    public List<Map<String,Object>> selectRecordsAndErrrecord(ParameterInfo parms);

    public List<Map<String,Object>> selectAllDayfreeze(ParameterInfo parms);

    public List<Map<String,Object>> selectAllMonfreeze(ParameterInfo parms);

    public List<Map<String,Object>> selectFreeze(ParameterInfo params);

    public List<Map<String,Object>> selectReplace(ParameterInfo params);

    public Integer insertRecords(HaMeter haMeter);

}
