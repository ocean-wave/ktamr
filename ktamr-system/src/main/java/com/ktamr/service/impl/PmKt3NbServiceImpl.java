package com.ktamr.service.impl;

import com.ktamr.mapper.PmKt3NbMapper;
import com.ktamr.service.PmKt3NbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class PmKt3NbServiceImpl implements PmKt3NbService {

    @Autowired
    private PmKt3NbMapper pmKt3NbMapper;

    @Override
    public Map<String, Object> selectPmKt3NbById(Integer id) {
        return pmKt3NbMapper.selectPmKt3NbById(id);
    }
}
