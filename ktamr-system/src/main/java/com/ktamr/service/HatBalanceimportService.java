package com.ktamr.service;

import com.ktamr.domain.HatBalanceimport;

public interface HatBalanceimportService {

    /**
     * 添加状态为待校验
     * @param hatBalanceimport
     * @return
     */
    public Integer insertHatBalanceimport(HatBalanceimport hatBalanceimport);
}
