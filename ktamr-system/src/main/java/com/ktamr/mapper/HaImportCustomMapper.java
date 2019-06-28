package com.ktamr.mapper;

import com.ktamr.domain.HaImportcustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HaImportCustomMapper {

    //新增用户资料零时表(待校验)
    Integer addImportCustom(@Param("params") List<Map<String, Object>> params);

    //清空导入用户资料零时表
    Integer deleteImportCustom(HaImportcustom haImportcustom);

}
