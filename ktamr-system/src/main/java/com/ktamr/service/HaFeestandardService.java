package com.ktamr.service;

import com.ktamr.domain.HaFeestandard;

import java.util.List;

public interface HaFeestandardService {

    List<HaFeestandard> HaFeestandardList(HaFeestandard haFeestandard);

    Integer addHaFeestandard(HaFeestandard haFeestandard);

    Integer updateHaFeestandard(HaFeestandard haFeestandard);

    HaFeestandard UpdateByIdHaFeestandard(HaFeestandard haFeestandard);

    Integer deleteHaFeestandard(HaFeestandard haFeestandard);

}
