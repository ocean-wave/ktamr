package com.ktamr.mapper;

import com.ktamr.domain.HaArea;

import java.util.List;


public interface HaAuditMapper {

    public List<String> selectAudit(HaArea params);

}
