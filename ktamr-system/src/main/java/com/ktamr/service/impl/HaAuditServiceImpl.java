package com.ktamr.service.impl;

import com.ktamr.domain.HaArea;
import com.ktamr.mapper.HaAuditMapper;
import com.ktamr.service.HaAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaAuditServiceImpl implements HaAuditService {

    @Autowired
    private HaAuditMapper haAuditMapper;

    @Override
    public List<String> selectAudit(HaArea params) {
        return haAuditMapper.selectAudit(params);
    }
}
