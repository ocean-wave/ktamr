package com.ktamr.service;

import com.ktamr.domain.HaArea;

import java.util.List;


public interface HaAuditService {

    public List<String> selectAudit(HaArea params);

}
