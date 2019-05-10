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
    public List<HaCustom> queryHaCustomList(@Param("HaCustom") HaCustom haCustom, @Param("page") Integer page,
                                            @Param("rowNum") Integer rowNum
    );

    /**
     * 查询用户账号列表的总记录数
     * @param haCustom
     * @return
     */
    public Integer queryHaCustomListCount(@Param("HaCustom") HaCustom haCustom);

    /**
     * 查询预存费用
     * @param haCustom
     * @return
     */
    public HaCustom selectYuCunFeiYong(HaCustom haCustom);

    /**
     * 佛系更新预存费用
     * @param haCustom
     * @return
     */
    public Integer updateYuCunFeiYong(HaCustom haCustom);


    List<HaCustom> HaCustomList(@Param("haCustom") HaCustom haCustom, @Param("page") Integer page, @Param("rowNum") Integer rowNum);

    HaCustom updateByIdHaCustom(@Param("haCustom") HaCustom haCustom);

    List<HaCustom> ByIdHaCustom(@Param("custId") Integer custId);

    Integer selectHaCustomCount(HaCustom haCustom);

    Integer addHaCustom(HaCustom haCustom);

    Integer updateHaCustom(HaCustom haCustom);

    Integer deleteHaCustom(HaCustom haCustom);
}
