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
    Integer deleteHaRoomC(HaRoom haRoom);

    /*
     *查询房间
     */
    List<HaRoom> queryAllRoomC(HaRoom haRoom,Integer page,Integer rowNum);

    /*
     *所属楼栋下的房间记录数
     */
    Integer allRoomCountC(HaRoom haRoom);
}
