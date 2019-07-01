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
     *
     * @param parms
     * @return
     */
    public List<HaBuilding> selectAllBuildingAndCount(HaBuilding parms);


    List<HaBuilding> HaBuildingListC(@Param("haBuilding") HaBuilding haBuilding);

    Integer HaBuildingCountC(HaBuilding haBuilding);

    /*
     *如果Id不为空查询楼栋
     */
    List<HaBuilding> queryHaBuildingC(@Param("areaId") Integer areaId);


    /*
     *新增楼栋
     */
    Integer addHaBuildingC(HaBuilding haBuilding);

    /*
     *修改楼栋
     */
    Integer updateHaBuildingC(HaBuilding haBuilding);

    /*
     *删除楼栋
     */
    Integer deleteHaBuildingC(HaBuilding haBuilding);

    /*
     *查询楼栋
     */
    List<HaBuilding> queryAllBuildingC();

    /*
     *小区下所属楼栋记录数
     */
    Integer allBuildingCountC(HaBuilding haBuilding);

    /*
     *条件查询楼栋
     */
    List<HaBuilding> queryHaBuildingConditionC(@Param("areaId") Integer areaId);

    HaBuilding updateByIdHaBuilding(@Param("buildingId") Integer buildingId);

    //修改时所属楼栋传值
    List<HaBuilding> BuildingByArea(HaBuilding haBuilding);

}
