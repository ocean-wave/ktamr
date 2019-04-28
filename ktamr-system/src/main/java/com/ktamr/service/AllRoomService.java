package com.ktamr.service;

import com.ktamr.domain.HaRoom;

import java.util.List;

public interface AllRoomService {

    List<HaRoom> queryAllRoom(HaRoom haRoom, Integer page, Integer rowNum);;

    Integer allRoomCount(HaRoom haRoom);


}
