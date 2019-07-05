package com.ktamr.service.impl;

import com.ktamr.domain.HaFeestandard;
import com.ktamr.mapper.HaFeestandardMapper;
import com.ktamr.service.HaFeestandardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaFeestandardServiceImpl implements HaFeestandardService {

    @Resource
    private HaFeestandardMapper haFeestandardMapper;

    @Override
    public List<HaFeestandard> HaFeestandardList(HaFeestandard haFeestandard) {
        List<HaFeestandard> haFeestandard1 = haFeestandardMapper.HaFeestandardList(haFeestandard);
        return haFeestandard1;
}

    @Override
    public Integer addHaFeestandard(HaFeestandard haFeestandard) {
        return haFeestandardMapper.addHaFeestandard(haFeestandard);
    }

    @Override
    public Integer updateHaFeestandard(HaFeestandard haFeestandard) {
        return haFeestandardMapper.updateHaFeestandard(haFeestandard);
    }

    @Override
    public HaFeestandard UpdateByIdHaFeestandard(HaFeestandard haFeestandard) {
        return haFeestandardMapper.UpdateByIdHaFeestandard(haFeestandard);
    }

    @Override
    public Integer deleteHaFeestandard(HaFeestandard haFeestandard) {
        return haFeestandardMapper.deleteHaFeestandard(haFeestandard);
    }

    @Override
    public Integer addingCellValidation2(HaFeestandard haFeestandard) {
        return haFeestandardMapper.addingCellValidation2(haFeestandard);
    }
}
