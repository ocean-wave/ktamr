package com.ktamr.mapper;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaGprsdtu;

import java.util.List;
import java.util.Map;

/**
 * 设备表Mapper
 */
public interface HaGprsdtuMapper {

    /**
     * 查询DTU信息并且统计下属集采器数目
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    public List<HaGprsdtu> selectAllGprsdtuAndCount(HaGprsdtu parms);

    List<HaGprsdtu> HaGprsdtuList(HaGprsdtu haGprsdtu);

    Integer addHaGprsdtu(HaGprsdtu haGprsdtu);

    Integer updateHaGprsdtu(HaGprsdtu haGprsdtu);

    Integer deleteHaGprsdtu(HaGprsdtu haGprsdtu);
}
