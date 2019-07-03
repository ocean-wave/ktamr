package com.ktamr.mapper;

import com.ktamr.domain.HaCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaCustomMapper {


    /**
     * 查询用户账号列表
     * @param haCustom
     * @return
     */
    public List<HaCustom> queryHaCustomListB(@Param("HaCustom") HaCustom haCustom);


    /**
     * 查询预存费用
     * @param haCustom
     * @return
     */
    public HaCustom selectYuCunFeiYongB(HaCustom haCustom);

    /**
     * 佛系更新预存费用
     * @param haCustom
     * @return
     */
    public Integer updateYuCunFeiYongB(HaCustom haCustom);


    List<HaCustom> HaCustomList(HaCustom haCustom);

    HaCustom updateByIdHaCustom(@Param("haCustom") HaCustom haCustom);

    List<HaCustom> ByIdHaCustom(@Param("custId") Integer custId);

    Integer selectHaCustomCount(HaCustom haCustom);

    Integer addHaCustom(HaCustom haCustom);

    Integer updateHaCustom(HaCustom haCustom);

    Integer deleteHaCustom(HaCustom haCustom);
}
