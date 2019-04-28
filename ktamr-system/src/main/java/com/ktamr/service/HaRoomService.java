package com.ktamr.service;


import com.ktamr.domain.HaRoom;

import java.util.List;

public interface HaRoomService {

    List<HaRoom> HaRoomList(HaRoom haRoom);

    List<HaRoom> queryRoom(Integer buildingId);

    Integer addHaRoom(HaRoom haRoom);

    Integer updateHaRoom(HaRoom haRoom);

    Integer deleteHaRoom(HaRoom haRoom);
}
