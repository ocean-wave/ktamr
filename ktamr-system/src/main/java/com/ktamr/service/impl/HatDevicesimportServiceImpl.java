package com.ktamr.service.impl;

import com.ktamr.domain.HatDevicesimport;
import com.ktamr.mapper.HatDevicesimportMapper;
import com.ktamr.service.HatDevicesimportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HatDevicesimportServiceImpl implements HatDevicesimportService {

    @Resource
    private HatDevicesimportMapper hatDevicesimportMapper;

    public List<HatDevicesimport> HatDevicesimportList(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.HatDevicesimportList(hatDevicesimport);
    }

    public Integer addHatDevicesimport(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.addHatDevicesimport(hatDevicesimport);
    }

    public Integer updateHatDevicesimport(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.updateHatDevicesimport(hatDevicesimport);
    }

    public Integer deleteHatDevicesimport(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.deleteHatDevicesimport(hatDevicesimport);
    }
}
