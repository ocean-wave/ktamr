package com.ktamr.service;

import com.ktamr.domain.HaArea;

import java.util.List;

public interface AllSmallAreaService {

    List<HaArea> queryAllSmallArea(HaArea haArea, Integer page,
                                   Integer rowNum);

    List<HaArea> queryAllSmallArea2(String areaNo);

    Integer smallAreaCount(HaArea haArea);

}
