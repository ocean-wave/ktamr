package com.ktamr.service.impl;

import com.ktamr.domain.HaOperatorRgns;
import com.ktamr.mapper.HaOperatorRgnsMapper;
import com.ktamr.service.HaOperatorRgnsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaOperatorRgnsServiceImpl implements HaOperatorRgnsService {

    @Resource
    private HaOperatorRgnsMapper haOperatorRgnsMapper;

    /**
     *  查询rgn_code
     * @param haOperatorRgns
     * @return
     */
    @Override
    public List<HaOperatorRgns> sql1(HaOperatorRgns haOperatorRgns) {
        List<HaOperatorRgns> sql1 = haOperatorRgnsMapper.sql1(haOperatorRgns);
        if(sql1!=null){
            return sql1;
        }
        return null;
    }

    /**
     * 查询Left(rgn_code, 1)
     * @param haOperatorRgns
     * @return
     */
    @Override
    public List<HaOperatorRgns> sql2(HaOperatorRgns haOperatorRgns) {
        List<HaOperatorRgns> sql2 = haOperatorRgnsMapper.sql2(haOperatorRgns);
        if(sql2!=null){
            return sql2;
        }
        return null;
    }

    @Override
    public HaOperatorRgns selRgnCodeStr(String operatorCode) {
        return haOperatorRgnsMapper.selRgnCodeStr(operatorCode);
    }
}
