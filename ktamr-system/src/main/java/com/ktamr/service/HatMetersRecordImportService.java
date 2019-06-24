package com.ktamr.service;

import com.ktamr.domain.HatBalanceimport;
import com.ktamr.domain.HatMetersRecordImport;

import java.util.List;
import java.util.Map;

public interface HatMetersRecordImportService {

    public Integer insertMetersRecordImport(List<Map<String, Object>> params);

    public Integer updateMetersRecordImport(String ImportTime);

    public Integer deleteMetersRecordImport(String ImportTime);

    public String selectLastImportTime();

    public List<HatMetersRecordImport> selectMetersRecordImportByImportTime(String ImportTime);

    public Integer selectMetersRecordImportCount(Map<String,Object> map);

}
