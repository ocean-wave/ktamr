package com.ktamr.service;


import com.ktamr.domain.HaRoom;

import java.util.List;

public interface HaRoomService {

    List<HaRoom> HaRoomListC(HaRoom haRoom);

    /*
     *查询房间如果id不为空
     */
    List<HaRoom> queryRoomC(Integer buildingId);

    /*
     *新增房间
     */
    Integer addHaRoomC(HaRoom haRoom);

    /*
     *修改房间
     */
    Integer updateHaRoomC(HaRoom haRoom);

    /*
     *删除房间
     */
    Integer deleteHaRoomC(Integer roomId);

    /*
     *查询房间
     */
    List<HaRoom> queryAllRoomC(HaRoom haRoom);

    /*
     *所属楼栋下的房间记录数
     */
    Integer allRoomCountC(HaRoom haRoom);

    HaRoom delByIdHaRoom(HaRoom haRoom);

    //拿到最后一个id
    HaRoom getLastId();

    HaRoom getByHaRoomAreaId(Integer roomId);

    HaRoom getByHaRoomBuildingId(Integer roomId);

    //用户档案模板导出
    List<HaRoom> customExport(Integer areaId);

    //修改时所属房间传值
    List<HaRoom> RoomByBuilding(HaRoom haRoom);
}
