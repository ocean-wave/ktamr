package com.ktamr.mapper;

import com.ktamr.domain.HavMeterinfo;

import java.util.List;
import java.util.Map;

/**
 * 视图HavMeterinfo
 */
public interface HavMeterinfoMapper {

    public List<HavMeterinfo> selectReadResult(Map<String,Object> parms);

}
