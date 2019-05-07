package com.ktamr.service.impl;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;
import com.ktamr.mapper.HaMeterMapper;
import com.ktamr.service.HaMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HaMeterServiceImpl implements HaMeterService {
    @Autowired
    private HaMeterMapper haMeterMapper;

    @Override
    public List<Map<String,Object>> selectAllMeter(ParameterInfo parms) {
        String[] s;
        Integer[] si;
        Map<String,Object> map;
        s = parms.getCmdids().toString().split(",");
        si = new Integer[s.length];
        String[] ids = parms.getIds().split(",");
        Integer[] id = new Integer[ids.length];
        if (ids.length>1){
            for (int i = 0; i < ids.length; i++) {
                id[i] = Integer.parseInt(ids[i]);
            }
        }
        if(s.length > 1) {
            for (int i = 0; i < s.length; i++) {
                si[i] = Integer.parseInt(s[i]);
            }
        }else{
            si[0] = 0;
        }
        map = new HashMap<String,Object>();
        map.put("cmdName",parms.getCmdName());
        map.put("cmdids",si);
        if(ids.length>1) {
            map.put("ids",id);
        }else {
            map.put("ids", parms.getIds());
        }
        return haMeterMapper.selectAllMeter(map);
    }

    @Override
    public Map<String, Object> selectMeterById(Integer meterid) {
        return haMeterMapper.selectMeterById(meterid);
    }

    @Override
    public Map<String, Object> selectMeterAndBuildingById(Integer meterid) {
        return haMeterMapper.selectMeterAndBuildingById(meterid);
    }

    @Override
    public List<Map<String, Object>> selectDosageRecently(ParameterInfo params) {
        return haMeterMapper.selectDosageRecently(params);
    }

    @Override
    public List<Map<String, Object>> selectDosageHistory(ParameterInfo params) {
        return haMeterMapper.selectDosageHistory(params);
    }

    @Override
    public List<Map<String, Object>> selectNotok(ParameterInfo params) {
        String[] str;
        if(params.getDataType() != null && params.getDataType() != ""){
            str = params.getDataType().split(",");
            for(int i = 0;i<str.length;i++){
                switch (str[i]){
                    case "LightChannelInterference":
                        str[i] = "光通道干扰";
                        break;
                    case "highlightInterference":
                        str[i] = "强光干扰";
                        break;
                    case "bubbleInterference":
                        str[i] = "气泡干扰";
                        break;
                    case "communicationBreadkdown":
                        str[i] = "通讯故障";
                        break;
                    case "meterBreakdown":
                        str[i] = "表具故障";
                        break;
                    case "valveBreakdown":
                        str[i] = "阀门故障";
                        break;
                    case "abnormal":
                        str[i] = "异常";
                        break;
                }
            }
            params.setDataTypes(str);
        }
        return haMeterMapper.selectNotok(params);
    }

    @Override
    public List<HaMeter> selectThirdParty(HaMeter haMeter) {
        return haMeterMapper.selectThirdParty(haMeter);
    }

    @Override
    public List<HaMeter> selectRecordByHand(HaMeter haMeter) {
        return haMeterMapper.selectRecordByHand(haMeter);
    }

    @Override
    public Integer updateMeter(HaMeter haMeter) {
        return haMeterMapper.updateMeter(haMeter);
    }

    @Override
    public List<HaMeter> selectMeterByCentorId(Integer centorId) {
        return haMeterMapper.selectMeterByCentorId(centorId);
    }

    @Override
    public List<HaMeter> selectMeterByCollectorId(Integer centorId) {
        return haMeterMapper.selectMeterByCollectorId(centorId);
    }

    public List<HaMeter> HaMeterList(HaMeter haMeter) {
        return haMeterMapper.HaMeterList(haMeter);
    }

    @Override
    public List<HaMeter> queryHaMeter(Integer areaId,Integer collectorid) {
        return haMeterMapper.queryHaMeter(areaId,collectorid);
    }

    public Integer addHaMeter(HaMeter haMeter) {
        return haMeterMapper.addHaMeter(haMeter);
    }

    public Integer updateHaMeter(HaMeter haMeter) {
        return haMeterMapper.updateHaMeter(haMeter);
    }

    public Integer deleteHaMeter(HaMeter haMeter) {
        return haMeterMapper.deleteHaMeter(haMeter);
    }
}
