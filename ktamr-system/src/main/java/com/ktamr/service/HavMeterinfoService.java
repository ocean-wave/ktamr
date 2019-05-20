package com.ktamr.service;

import com.ktamr.domain.HavMeterinfo;

import java.util.List;
import java.util.Map;

/**
 * 视图HavMeterinfo
 */
public interface HavMeterinfoService {

    public List<HavMeterinfo> selectReadResult(HavMeterinfo parms);

}
