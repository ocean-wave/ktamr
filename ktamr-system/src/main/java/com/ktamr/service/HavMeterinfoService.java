package com.ktamr.service;

import com.ktamr.domain.HavMeterinfo;

import java.util.List;

/**
 * 视图HavMeterinfo
 */
public interface HavMeterinfoService {

    public List<HavMeterinfo> selectReadResult(HavMeterinfo parms);

}
