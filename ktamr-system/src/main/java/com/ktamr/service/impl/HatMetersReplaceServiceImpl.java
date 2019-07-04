package com.ktamr.service.impl;

import com.ktamr.domain.HatMetersreplace;
import com.ktamr.mapper.HatMetersReplaceMapper;
import com.ktamr.service.HatMetersReplaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HatMetersReplaceServiceImpl implements HatMetersReplaceService {

    @Resource
    private HatMetersReplaceMapper hatMetersReplaceMapper;

    @Override
    public List<HatMetersreplace> HatMetersReplaceList(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.HatMetersReplaceList(hatMetersreplace);
    }

    @Override
    public Integer addHatMetersReplace(List<Map<String, Object>> params) {
        return hatMetersReplaceMapper.addHatMetersReplace(params);
    }

    @Override
    public Integer exportCustomNoCheck1(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportCustomNoCheck1(hatMetersreplace);
    }

    @Override
    public Integer exportCustomNoCheck2(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportCustomNoCheck2(hatMetersreplace);
    }

    @Override
    public Integer exportArchivesMeterNumCheck1(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportArchivesMeterNumCheck1(hatMetersreplace);
    }

    @Override
    public Integer exportArchivesMeterNumCheck2(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportArchivesMeterNumCheck2(hatMetersreplace);
    }

    @Override
    public Integer exportArchivesMeterNumCheck3(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportArchivesMeterNumCheck3(hatMetersreplace);
    }

    @Override
    public Integer exportArchivesMeterNumCheck4(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportArchivesMeterNumCheck4(hatMetersreplace);
    }

    @Override
    public Integer exportArchivesMeterNumCheck5(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.exportArchivesMeterNumCheck5(hatMetersreplace);
    }

    @Override
    public Integer matchCustomNo(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.matchCustomNo(hatMetersreplace);
    }

    @Override
    public Integer matchOldMeterNo(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.matchOldMeterNo(hatMetersreplace);
    }

    @Override
    public Integer makeUpDefaultNum(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.makeUpDefaultNum(hatMetersreplace);
    }

    @Override
    public Integer addBatchChangeMeter(String fileName, String operatorCode, String msg) {
        return hatMetersReplaceMapper.addBatchChangeMeter(fileName,operatorCode,msg);
    }

    @Override
    public Integer addOldMeterLastMeterRead(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastMeterRead(hatMetersreplace);
    }

    @Override
    public Integer addOldMeterLastDayFrozen1(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastDayFrozen1(hatMetersreplace);
    }

    @Override
    public Integer addOldMeterLastDayFrozen2(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastDayFrozen2(hatMetersreplace);
    }

    @Override
    public Integer addOldMeterLastDayFrozen3(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastDayFrozen3(hatMetersreplace);
    }

    @Override
    public Integer addOldMeterLastMonthFrozen1(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastMonthFrozen1(hatMetersreplace);
    }

    @Override
    public Integer addOldMeterLastMonthFrozen2(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastMonthFrozen2(hatMetersreplace);
    }

    @Override
    public Integer addOldMeterLastMonthFrozen3(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addOldMeterLastMonthFrozen3(hatMetersreplace);
    }

    @Override
    public Integer changeMeter(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.changeMeter(hatMetersreplace);
    }

    @Override
    public Integer addChangeMeterNote(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.addChangeMeterNote(hatMetersreplace);
    }

    @Override
    public Integer finishChangeMeter(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.finishChangeMeter(hatMetersreplace);
    }

    @Override
    public Integer deleteHatMetersReplace(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.deleteHatMetersReplace(hatMetersreplace);
    }

    @Override
    public Integer allrows(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.allrows(hatMetersreplace);
    }

    @Override
    public Integer replaces(HatMetersreplace hatMetersreplace) {
        return hatMetersReplaceMapper.replaces(hatMetersreplace);
    }
}
