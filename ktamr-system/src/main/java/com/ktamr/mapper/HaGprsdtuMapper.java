package com.ktamr.mapper;

import com.ktamr.domain.HaGprsdtu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


    List<HaGprsdtu> HaGprsdtuList(@Param("haGprsdtu") HaGprsdtu haGprsdtu);

    HaGprsdtu updateByIdHaGprsdtu(@Param("haGprsdtu")HaGprsdtu haGprsdtu);

    Integer HaGprsdtuCount(HaGprsdtu haGprsdtu);

    Integer addHaGprsdtu(HaGprsdtu haGprsdtu);

    Integer updateHaGprsdtu(HaGprsdtu haGprsdtu);

    Integer deleteHaGprsdtu(HaGprsdtu haGprsdtu);

    public Integer addingCellValidation(HaGprsdtu haGprsdtu);
}
