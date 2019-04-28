package com.ktamr.service;

import com.ktamr.domain.HaRgn;

import java.util.List;

/**
 * 大区表Service
 */
public interface HaRngService {

    /**
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量
     * @return
     */
    public List<HaRgn> selectAllRngAndCount(HaRgn haRgn);

    /**
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量
     * @return
     */
    public List<HaRgn> selectAllRngAndCount();

    /**
     * 查询大区的名字
     * @return
     */
    public List<HaRgn> selectBigName();

    /**
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量
     * @return
     */
    public List<HaRgn> selectAllRngAndCount(HaRgn haRgn, Integer page,
                                            Integer rowNum);

    List<HaRgn> queryAllRng();

    HaRgn updateByIdRng(HaRgn haRgn);

    Integer HaRgnCount(HaRgn haRgn);

    Integer addHaRgn(HaRgn haRgn);

    Integer updateHaRgn(HaRgn haRgn);

    Integer deleteHaRgn(HaRgn haRgn);

    Integer count0();

    Integer countA();

    Integer countla();

    Integer countNumber();

    Integer countUpperCase();

    String elseId();

}
