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
    public Integer deleteHaRoomC(Integer roomId) {
        return haRoomMapper.deleteHaRoomC(roomId);
    }

    /*
     *查询房间
     */
    @Override
    public List<HaRoom> queryAllRoomC(HaRoom haRoom) {
        return haRoomMapper.queryAllRoomC(haRoom);
    }

    /*
     *所属楼栋下的房间记录数
     */
    @Override
    public Integer allRoomCountC(HaRoom haRoom) {
        return haRoomMapper.allRoomCountC(haRoom);
    }

    @Override
    public HaRoom delByIdHaRoom(HaRoom haRoom) {
        return haRoomMapper.delByIdHaRoom(haRoom);
    }

    @Override
    public HaRoom getByNameHaRoom(Integer buildid, String name) {
        return haRoomMapper.getByNameHaRoom(buildid,name);
    }

    @Override
    public Integer DeleteRoomsById(Integer custid) {
        return haRoomMapper.DeleteRoomsById(custid);
    }

    @Override
    public Integer SetRelateRoom(Integer custid, Integer roomid) {
        return haRoomMapper.SetRelateRoom(custid,roomid);
    }

    @Override
    public HaRoom getLastId() {
        return haRoomMapper.getLastId();
    }

    @Override
    public HaRoom getByHaRoomAreaId(Integer roomId) {
        return haRoomMapper.getByHaRoomAreaId(roomId);
    }

    @Override
    public HaRoom getByHaRoomBuildingId(Integer roomId) {
        return haRoomMapper.getByHaRoomBuildingId(roomId);
    }

    @Override
    public List<HaRoom> customExport(Integer areaId) {
        return haRoomMapper.customExport(areaId);
    }

    @Override
    public List<HaRoom> RoomByBuilding(HaRoom haRoom) {
        return haRoomMapper.RoomByBuilding(haRoom);
    }

    @Override
    public Integer addingCellValidation(HaRoom haRoom) {
        return haRoomMapper.addingCellValidation(haRoom);
    }
}
