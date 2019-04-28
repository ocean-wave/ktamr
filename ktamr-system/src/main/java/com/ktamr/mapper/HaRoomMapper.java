package com.ktamr.mapper;

import com.ktamr.domain.HaRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaRoomMapper {

    List<HaRoom> HaRoomList(HaRoom haRoom);

    List<HaRoom> queryRoom(@Param("buildingId") Integer buildingId);

    Integer addHaRoom(HaRoom haRoom);

    Integer updateHaRoom(HaRoom haRoom);

    Integer deleteHaRoom(HaRoom haRoom);
}
