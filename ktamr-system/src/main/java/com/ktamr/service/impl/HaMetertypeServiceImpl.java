package com.ktamr.service.impl;


import com.ktamr.domain.HaMetertype;
import com.ktamr.mapper.HaMetertypeMapper;
import com.ktamr.service.HaMetertypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaMetertypeServiceImpl implements HaMetertypeService {

    @Resource
    private HaMetertypeMapper haMetertypeMapper;

    public List<HaMetertype> HaMetertypeList(HaMetertype haMetertype) {
        return haMetertypeMapper.HaMetertypeList(haMetertype);
    }

    @Override
    public List<HaMetertype> watchTypeList(HaMetertype haMetertype) {
        return haMetertypeMapper.watchTypeList(haMetertype);
    }

    public Integer addHaMetertype(HaMetertype haMetertype) {
        return haMetertypeMapper.addHaMetertype(haMetertype);
    }

    public Integer updateHaMetertype(HaMetertype haMetertype) {
        return haMetertypeMapper.updateHaMetertype(haMetertype);
    }

    public Integer deleteHaMetertype(HaMetertype haMetertype) {
        return haMetertypeMapper.deleteHaMetertype(haMetertype);
    }
}
