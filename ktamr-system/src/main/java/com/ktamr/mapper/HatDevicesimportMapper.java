package com.ktamr.mapper;

import com.ktamr.domain.HatDevicesimport;

import java.util.List;

public interface HatDevicesimportMapper {

    List<HatDevicesimport> HatDevicesimportList(HatDevicesimport hatDevicesimport);

    Integer addHatDevicesimport(HatDevicesimport hatDevicesimport);

    Integer updateHatDevicesimport(HatDevicesimport hatDevicesimport);

    Integer deleteHatDevicesimport(HatDevicesimport hatDevicesimport);
}
