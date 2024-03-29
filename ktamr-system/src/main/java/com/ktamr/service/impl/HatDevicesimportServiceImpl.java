package com.ktamr.service.impl;

import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HatDevicesimport;
import com.ktamr.mapper.HatDevicesimportMapper;
import com.ktamr.service.HatDevicesimportService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HatDevicesimportServiceImpl implements HatDevicesimportService {

    @Resource
    private HatDevicesimportMapper hatDevicesimportMapper;

    public List<HatDevicesimport> HatDevicesimportList(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.HatDevicesimportList(hatDevicesimport);
    }

    public Integer addHatDevicesimport(List<Map<String, Object>> params) {
        return hatDevicesimportMapper.addHatDevicesimport(params);
    }

    public Integer updateHatDevicesimport(HaCentor haCentor, HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.updateHatDevicesimport(haCentor,hatDevicesimport);
    }

    public Integer deleteHatDevicesimport(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.deleteHatDevicesimport(hatDevicesimport);
    }

    @Override
    public Integer belongAreaCheck(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.belongAreaCheck(hatDevicesimport);
    }

    @Override
    public Integer joinSayCheck(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.joinSayCheck(hatDevicesimport);
    }

    @Override
    public Integer centorNameCheck(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorNameCheck(hatDevicesimport);
    }

    @Override
    public Integer centorAddrCheck1(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorAddrCheck1(hatDevicesimport);
    }

    @Override
    public Integer centorAddrCheck2(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorAddrCheck2(hatDevicesimport);
    }

    @Override
    public Integer centorAddrCheck3(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorAddrCheck3(hatDevicesimport);
    }

    @Override
    public Integer centorAddrCheck4(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorAddrCheck4(hatDevicesimport);
    }

    @Override
    public Integer centorAddrCheck5(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorAddrCheck5(hatDevicesimport);
    }

    @Override
    public Integer centorAddrCheck6(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.centorAddrCheck6(hatDevicesimport);
    }

    @Override
    public Integer checkAddOrUpdate(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.checkAddOrUpdate(hatDevicesimport);
    }

    @Override
    public Integer completeDefaultValues(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.completeDefaultValues(hatDevicesimport);
    }

    @Override
    public Integer queryAllHatDevicesimportCount(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.queryAllHatDevicesimportCount(hatDevicesimport);
    }

    @Override
    public Integer addsCount(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.addsCount(hatDevicesimport);
    }

    @Override
    public Integer updsCount(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.updsCount(hatDevicesimport);
    }

    @Override
    public Integer addCentorsAndHandDevices(HatDevicesimport hatDevicesimport) {
        return hatDevicesimportMapper.addCentorsAndHandDevices(hatDevicesimport);
    }
}
