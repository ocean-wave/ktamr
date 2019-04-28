package com.ktamr.service.impl;

import com.ktamr.domain.HaRgn;
import com.ktamr.mapper.AllBigAreaMapper;
import com.ktamr.service.AllBigAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllBigAreaServiceImpl implements AllBigAreaService {

    @Resource
    private AllBigAreaMapper allBigAreaMapper;

    @Override
    public List<HaRgn> queryAllBigArea() {
        return allBigAreaMapper.queryAllBigArea();
    }
}
