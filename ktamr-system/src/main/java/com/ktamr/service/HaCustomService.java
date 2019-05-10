package com.ktamr.service;

import com.ktamr.domain.HaCustom;

import java.util.List;

public interface HaCustomService {


    /**
     * 查询用户账号列表
     * @param haCustom
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaCustom> queryHaCustomList(HaCustom haCustom, Integer page,
                                            Integer rowNum
    );

    /**
     * 查询用户账号列表的总记录数
     * @param haCustom
     * @return
     */
    public Integer queryHaCustomListCount(HaCustom haCustom);


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

    List<HaCustom> HaCustomList(HaCustom haCustom, Integer page,
                                Integer rowNum);

    HaCustom updateByIdHaCustom(HaCustom haCustom);

    List<HaCustom> ByIdHaCustom(Integer custId);

    Integer selectHaCustomCount(HaCustom haCustom);

    Integer addHaCustom(HaCustom haCustom);

    Integer updateHaCustom(HaCustom haCustom);

    Integer deleteHaCustom(HaCustom haCustom);
}
