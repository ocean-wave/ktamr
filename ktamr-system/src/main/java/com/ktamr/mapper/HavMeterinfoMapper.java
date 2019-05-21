package com.ktamr.mapper;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HavMeterinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 视图HavMeterinfo
 */
public interface HavMeterinfoMapper {

    public List<HavMeterinfo> selectReadResult(Map<String,Object> parms);

}
