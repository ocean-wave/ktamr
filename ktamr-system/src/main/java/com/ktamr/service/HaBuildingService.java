package com.ktamr.service;

import com.ktamr.domain.HaBuilding;

import java.util.List;

public interface HaBuildingService {

    public List<HaBuilding> selectAllBuildingAndCount(HaBuilding parms);

    List<HaBuilding> HaBuildingListC(HaBuilding haBuilding);

    Integer HaBuildingCountC(HaBuilding haBuilding);

    /*
     *如果Id不为空查询楼栋
     */
    List<HaBuilding> queryHaBuildingC(Integer areaId);

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
    List<HaBuilding> queryHaBuildingConditionC(Integer areaId);

    HaBuilding updateByIdHaBuilding(Integer buildingId);

}
