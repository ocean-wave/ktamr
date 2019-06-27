package com.ktamr.service.impl;

import com.ktamr.domain.HatBalanceimport;
import com.ktamr.domain.HatMetersRecordImport;
import com.ktamr.mapper.HatMetersRecordImportMapper;
import com.ktamr.service.HatMetersRecordImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HatMetersRecordImportServiceImpl implements HatMetersRecordImportService {
    @Autowired
    private HatMetersRecordImportMapper HatMetersRecordImportMapper;

    @Override
    public Integer insertMetersRecordImport(List<Map<String, Object>> params) {
        return HatMetersRecordImportMapper.insertMetersRecordImport(params);
    }

    @Override
    public Integer updateMetersRecordImport(String ImportTime) {
        return HatMetersRecordImportMapper.updateMetersRecordImport(ImportTime);
    }

    @Override
    public Integer updateMetersRecordImportTwo(String ImportTime) {
        return HatMetersRecordImportMapper.updateMetersRecordImportTwo(ImportTime);
    }

    @Override
    public Integer updateMetersRecordImportThree(String ImportTime) {
        return HatMetersRecordImportMapper.updateMetersRecordImportThree(ImportTime);
    }

    @Override
    public Integer deleteMetersRecordImport(String ImportTime) {
        return HatMetersRecordImportMapper.deleteMetersRecordImport(ImportTime);
    }

    @Override
    public String selectLastImportTime() {
        return HatMetersRecordImportMapper.selectLastImportTime();
    }

    @Override
    public List<HatMetersRecordImport> selectMetersRecordImportByImportTime(String ImportTime) {
        return HatMetersRecordImportMapper.selectMetersRecordImportByImportTime(ImportTime);
    }

    @Override
    public Integer selectMetersRecordImportCount(Map<String, Object> map) {
        return HatMetersRecordImportMapper.selectMetersRecordImportCount(map);
    }

}
