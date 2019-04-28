package com.ktamr.mapper;

import com.ktamr.domain.HaRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllRoomMapper {

    List<HaRoom> queryAllRoom(@Param("haRoom") HaRoom haRoom, @Param("page") Integer page,
                              @Param("rowNum") Integer rowNum);

    Integer allRoomCount(HaRoom haRoom);


}
