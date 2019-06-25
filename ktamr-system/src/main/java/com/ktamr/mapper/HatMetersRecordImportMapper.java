package com.ktamr.mapper;

import com.ktamr.domain.HaCmd;
import com.ktamr.domain.HaMeter;
import com.ktamr.domain.HatBalanceimport;
import com.ktamr.domain.HatMetersRecordImport;
import com.ktamr.domain.HatMetersRecordImport;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HatMetersRecordImportMapper {

    public Integer insertMetersRecordImport(@Param("params") List<Map<String, Object>> params);

    public Integer updateMetersRecordImport(String ImportTime);

    public Integer deleteMetersRecordImport(String ImportTime);

    public String selectLastImportTime();

    public List<HatMetersRecordImport> selectMetersRecordImportByImportTime(String ImportTime);

    public Integer selectMetersRecordImportCount(Map<String,Object> map);

}
