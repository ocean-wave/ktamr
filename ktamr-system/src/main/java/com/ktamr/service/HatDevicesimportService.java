package com.ktamr.service;


import com.ktamr.domain.HatDevicesimport;

import java.util.List;

public interface HatDevicesimportService {

    List<HatDevicesimport> HatDevicesimportList(HatDevicesimport hatDevicesimport);

    Integer addHatDevicesimport(HatDevicesimport hatDevicesimport);

    Integer updateHatDevicesimport(HatDevicesimport hatDevicesimport);

    Integer deleteHatDevicesimport(HatDevicesimport hatDevicesimport);
}
