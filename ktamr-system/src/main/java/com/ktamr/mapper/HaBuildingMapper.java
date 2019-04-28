package com.ktamr.mapper;

import com.ktamr.domain.HaBuilding;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 楼栋表Mapper
 */
public interface HaBuildingMapper {

    /**
     * 查询楼栋信息并且实现分页
     * @param parms
     * @return
     */
    public List<HaBuilding> selectAllBuildingAndCount(HaBuilding parms);


    List<HaBuilding> HaBuildingList(HaBuilding haBuilding);

    List<HaBuilding> queryHaBuilding(@Param("areaId") Integer areaId);

    Integer addHaBuilding(HaBuilding haBuilding);

    Integer updateHaBuilding(HaBuilding haBuilding);

    Integer deleteHaBuilding(HaBuilding haBuilding);

}
