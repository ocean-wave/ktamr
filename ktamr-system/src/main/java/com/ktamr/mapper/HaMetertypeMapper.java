package com.ktamr.mapper;

import com.ktamr.domain.HaMetertype;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface HaMetertypeMapper {

    List<HaMetertype> HaMetertypeList(HaMetertype haMetertype);

    List<HaMetertype> watchTypeList(@Param("haMetertype") HaMetertype haMetertype);

    Integer addHaMetertype(HaMetertype haMetertype);

    Integer updateHaMetertype(HaMetertype haMetertype);

    Integer deleteHaMetertype(HaMetertype haMetertype);
}
