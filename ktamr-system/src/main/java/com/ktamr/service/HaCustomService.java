package com.ktamr.service;

import com.ktamr.domain.HaCustom;

import java.util.List;

public interface HaCustomService {


    /**
     * 查询用户账号列表
     * @param haCustom
     * @return
     */
    public List<HaCustom> queryHaCustomListB(HaCustom haCustom
    );



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

    HaCustom updateByIdHaCustom(HaCustom haCustom);

    List<HaCustom> ByIdHaCustom(Integer custId);

    Integer selectHaCustomCount(HaCustom haCustom);

    Integer addHaCustom(HaCustom haCustom);

    Integer updateHaCustom(HaCustom haCustom);

    Integer deleteHaCustom(HaCustom haCustom);

    public Integer addingCellValidation(HaCustom haCustom);
}
