package com.ktamr.service.impl;

import com.ktamr.domain.HaRoom;
import com.ktamr.mapper.AllRoomMapper;
import com.ktamr.service.AllRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllRoomServiceImpl implements AllRoomService {

    @Resource
    private AllRoomMapper allRoomMapper;


    @Override
    public List<HaRoom> queryAllRoom(HaRoom haRoom, Integer page, Integer rowNum) {
        return allRoomMapper.queryAllRoom(haRoom,page,rowNum);
    }

    @Override
    public Integer allRoomCount(HaRoom haRoom) {
        return allRoomMapper.allRoomCount(haRoom);
    }
}
