package com.ktamr.service;

import com.ktamr.domain.HaMetertype;

import java.util.List;

public interface HaMetertypeService {

    List<HaMetertype> HaMetertypeList(HaMetertype haMetertype);

    List<HaMetertype> watchTypeList(HaMetertype haMetertype);

    Integer addHaMetertype(HaMetertype haMetertype);

    Integer updateHaMetertype(HaMetertype haMetertype);

    Integer deleteHaMetertype(HaMetertype haMetertype);
}
