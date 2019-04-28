package com.ktamr.mapper;

import com.ktamr.domain.HaRgn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 大区表Mapper
 */
public interface HaRngMapper {

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
    public List<HaRgn> selectAllRngAndCount(@Param("haRgn") HaRgn haRgn, @Param("page") Integer page,
                                            @Param("rowNum") Integer rowNum);

    /**
     * 查询所有大区
     * @return
     */
    List<HaRgn> queryAllRng();

    HaRgn updateByIdRng(@Param("haRgn") HaRgn haRgn);

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
