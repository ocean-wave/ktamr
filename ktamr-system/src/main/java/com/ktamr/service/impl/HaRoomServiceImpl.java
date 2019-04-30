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

    public List<HaRoom> HaRoomListC(HaRoom haRoom) {
        return haRoomMapper.HaRoomListC(haRoom);
    }

    /*
     *查询房间如果id不为空
     */
    @Override
    public List<HaRoom> queryRoomC(Integer buildingId) {
        return haRoomMapper.queryRoomC(buildingId);
    }

    /*
     *新增房间
     */
    public Integer addHaRoomC(HaRoom haRoom) {
        return haRoomMapper.addHaRoomC(haRoom);
    }

    /*
     *修改房间
     */
    public Integer updateHaRoomC(HaRoom haRoom) {
        return haRoomMapper.updateHaRoomC(haRoom);
    }

    /*
     *删除房间
     */
    public Integer deleteHaRoomC(HaRoom haRoom) {
        return haRoomMapper.deleteHaRoomC(haRoom);
    }

    /*
     *查询房间
     */
    @Override
    public List<HaRoom> queryAllRoomC(HaRoom haRoom, Integer page, Integer rowNum) {
        return haRoomMapper.queryAllRoomC(haRoom, page, rowNum);
    }

    /*
     *所属楼栋下的房间记录数
     */
    @Override
    public Integer allRoomCountC(HaRoom haRoom) {
        return haRoomMapper.allRoomCountC(haRoom);
    }
}
