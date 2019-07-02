package com.ktamr.mapper;


import com.ktamr.domain.HaOperatorRgns;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaOperatorRgnsMapper {

    /**
     * 查询rgn_code
     * @param haOperatorRgns
     * @return
     */
    public List<HaOperatorRgns> sql1(HaOperatorRgns haOperatorRgns);

    /**
     * 查询Left(rgn_code, 1)
     * @param haOperatorRgns
     * @return
     */
    public List<HaOperatorRgns> sql2(HaOperatorRgns haOperatorRgns);

    List<HaOperatorRgns> selRgnCodeStr(@Param("operatorCode")String operatorCode);

    Integer addHaOperatorRgns(HaOperatorRgns haOperatorRgns);

    Integer deleteHaOperatorRgns(HaOperatorRgns haOperatorRgns);
}
