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
    public List<HaRgn> selectAllRngAndCountC(HaRgn haRgn,Integer page,Integer rowNum);

    /**
     * 大区下拉框
     * @return
     */
    List<HaRgn> queryAllRngC();

    /**
     * 修改大区传值
     * @return
     */
    HaRgn updateByIdRngC(HaRgn haRgn);

    /**
     * 记录数
     * @return
     */
    Integer HaRgnCountC(HaRgn haRgn);

    /**
     * 添加大区
     * @return
     */
    Integer addHaRgnC(HaRgn haRgn);

    /**
     * 修改大区
     * @return
     */
    Integer updateHaRgnC(HaRgn haRgn);

    /**
     * 删除大区
     * @return
     */
    Integer deleteHaRgnC(HaRgn haRgn);

    /**
     * 新增大区前判断id
     * @return
     */
    Integer count0();

    Integer countA();

    Integer countla();

    Integer countNumber();

    Integer countUpperCase();

    String elseId();

    /**
     * 节点-所有大区
     * @return
     */
    List<HaRgn> queryAllBigAreaC();

}
