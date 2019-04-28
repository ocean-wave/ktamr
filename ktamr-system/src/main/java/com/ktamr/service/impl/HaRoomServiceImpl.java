package com.ktamr.service.impl;


import com.ktamr.domain.HaRoom;
import com.ktamr.mapper.HaRoomMapper;
import com.ktamr.service.HaRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaRoomServiceImpl implements HaRoomService {

    @Resource
    private HaRoomMapper haRoomMapper;

    public List<HaRoom> HaRoomList(HaRoom haRoom) {
        return haRoomMapper.HaRoomList(haRoom);
    }

    @Override
    public List<HaRoom> queryRoom(Integer buildingId) {
        return haRoomMapper.queryRoom(buildingId);
    }

    public Integer addHaRoom(HaRoom haRoom) {
        return haRoomMapper.addHaRoom(haRoom);
    }

    public Integer updateHaRoom(HaRoom haRoom) {
        return haRoomMapper.updateHaRoom(haRoom);
    }

    public Integer deleteHaRoom(HaRoom haRoom) {
        return haRoomMapper.deleteHaRoom(haRoom);
    }
}
