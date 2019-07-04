package com.ktamr.mapper;

import com.ktamr.domain.HaFeestandard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaFeestandardMapper {

    List<HaFeestandard> HaFeestandardList(@Param("haFeestandard") HaFeestandard haFeestandard);

    Integer addHaFeestandard(HaFeestandard haFeestandard);

    Integer updateHaFeestandard(HaFeestandard haFeestandard);

    HaFeestandard UpdateByIdHaFeestandard(HaFeestandard haFeestandard);

    Integer deleteHaFeestandard(HaFeestandard haFeestandard);

    public Integer addingCellValidation2(HaFeestandard haFeestandard);
}
