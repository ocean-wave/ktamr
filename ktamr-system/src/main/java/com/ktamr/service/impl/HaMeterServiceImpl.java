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

/**
 * 表具资料表实现类
 */
@Service
public class HaMeterServiceImpl implements HaMeterService {
    @Autowired
    private HaMeterMapper haMeterMapper;

    @Override
    public Map<String, Object> selectMeterById(Integer meterid) {
        return haMeterMapper.selectMeterById(meterid);
    }

    /**
     * 查询表具资料表与房间表信息
     * @param meterId 根据id查询
     * @return 返回对象
     */
    @Override
    public HaMeter selectMeterAndBuildingById(Integer meterId) {
        return haMeterMapper.selectMeterAndBuildingById(meterId);
    }

    /**
     * 查询HaMeter表信息
     * @param params 对象参数
     * @return 返回泛型集合对象
     */
    @Override
    public List<HaMeter> selectDosageRecently(HaMeter params) {
        return haMeterMapper.selectDosageRecently(params);
    }

    /**
     * 查询不良表信息
     * @param params 对象参数
     * @return 返回泛型集合
     */
    @Override
    public List<HaMeter> selectNotok(HaMeter params) {
        String[] str;
        if(params.getParams().get("dataType") != null){
            str = params.getParams().get("dataType").toString().split(",");
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
            params.getParams().put("dataTypes",str);
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

    /**
     * 根据centorId查询meter表信息
     * @param centorId 参数centorId
     * @return 返回泛型集合对象
     */
    @Override
    public List<HaMeter> selectMeterByCentorId(Integer centorId) {
        return haMeterMapper.selectMeterByCentorId(centorId);
    }

    /**
     * 根据CollectorId查询meter表信息
     * @param collectorId 参数CollectorId
     * @return 返回泛型集合对象
     */
    @Override
    public List<HaMeter> selectMeterByCollectorId(Integer collectorId) {
        return haMeterMapper.selectMeterByCollectorId(collectorId);
    }

    public List<HaMeter> HaMeterList(HaMeter haMeter,Integer page,Integer rowNum) {
        return haMeterMapper.HaMeterList(haMeter,page,rowNum);
    }

    @Override
    public List<HaMeter> queryHaMeter(Integer areaId,Integer collectorid,Integer page,Integer rowNum) {
        return haMeterMapper.queryHaMeter(areaId,collectorid,page,rowNum);
    }

    @Override
    public Integer HaMeterCount(HaMeter haMeter) {
        return haMeterMapper.HaMeterCount(haMeter);
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

    /**
     * 主页统计表==》表列表
     * @param haMeter
     * @param page
     * @param rowNum
     * @return 全部数据List集合
     */
    @Override
    public List<HaMeter> zhuYegetStateMeter(HaMeter haMeter, Integer page, Integer rowNum) {
        List<HaMeter> haMeterList = haMeterMapper.zhuYegetStateMeter(haMeter, page, rowNum);
        if(haMeterList!=null){
            return haMeterList;
        }
        return null;
    }

    /**
     * 主页统计表==》表列表
     * @param haMeter
     * @return 全部数据的总记录数
     */
    @Override
    public Integer zhuYegetStateMeterCount(HaMeter haMeter) {
        Integer zhuYegetStateMeterCount = haMeterMapper.zhuYegetStateMeterCount(haMeter);
        if(zhuYegetStateMeterCount!=null){
            return zhuYegetStateMeterCount;
        }
        return null;
    }
}
