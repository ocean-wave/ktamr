package com.ktamr.service.impl;

import com.ktamr.domain.HaPricestandard;
import com.ktamr.mapper.HaPricestandardMapper;
import com.ktamr.service.HaPricestandardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaPricestandardServiceImpl implements HaPricestandardService {

    @Resource
    private HaPricestandardMapper haPricestandardMapper;

    public List<HaPricestandard> HaPricestandardList(HaPricestandard haPricestandard) {
        return haPricestandardMapper.HaPricestandardList(haPricestandard);
    }

    @Override
    public Integer selectHaPricestandardCount(HaPricestandard haPricestandard) {
        return haPricestandardMapper.selectHaPricestandardCount(haPricestandard);
    }

    @Override
    public HaPricestandard updateByIdHaPricestandard(HaPricestandard haPricestandard) {
        return haPricestandardMapper.updateByIdHaPricestandard(haPricestandard);
    }

    public Integer addHaPricestandard(HaPricestandard haPricestandard) {
        return haPricestandardMapper.addHaPricestandard(haPricestandard);
    }

    public Integer updateHaPricestandard(HaPricestandard haPricestandard) {
        return haPricestandardMapper.updateHaPricestandard(haPricestandard);
    }

    public Integer deleteHaPricestandard(HaPricestandard haPricestandard) {
        return haPricestandardMapper.deleteHaPricestandard(haPricestandard);
    }

    @Override
    public List<HaPricestandard> PriceStandardGenOptionSelected() {
        return haPricestandardMapper.PriceStandardGenOptionSelected();
    }

    @Override
    public HaPricestandard queryPName(Integer pricestandardId) {
        return haPricestandardMapper.queryPName(pricestandardId);
    }
}
