package com.ktamr.mapper;

import com.ktamr.domain.HaRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaRoomMapper {

    List<HaRoom> HaRoomListC(HaRoom haRoom);

    /*
     *查询房间如果id不为空
     */
    List<HaRoom> queryRoomC(@Param("buildingId") Integer buildingId);

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
    List<HaRoom> queryAllRoomC(@Param("haRoom") HaRoom haRoom);

    /*
     *所属楼栋下的房间记录数
     */
    Integer allRoomCountC(HaRoom haRoom);
}
