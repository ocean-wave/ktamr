package com.ktamr.service;


import com.ktamr.domain.HaOperatorRgns;

import java.util.List;

public interface HaOperatorRgnsService {

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

    HaOperatorRgns selRgnCodeStr(String operatorCode);
}
