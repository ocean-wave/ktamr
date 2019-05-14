package com.ktamr.service;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;

import java.util.List;
import java.util.Map;

/**
 * 表具资料表Service
 */
public interface HaMeterService {

    public List<Map<String,Object>> selectAllMeter(ParameterInfo parms);

    public Map<String,Object> selectMeterById(Integer meterid);

    public Map<String,Object> selectMeterAndBuildingById(Integer meterid);

    /**
     * 查询HaMeter表信息
     * @param params 对象参数
     * @return 返回泛型集合对象
     */
    public List<HaMeter> selectDosageRecently(HaMeter params);

    /**
     * 查询不良表信息
     * @param params 对象参数
     * @return 返回泛型集合
     */
    public List<HaMeter> selectNotok(HaMeter params);

    public List<HaMeter> selectThirdParty(HaMeter haMeter);

    public List<HaMeter> selectRecordByHand(HaMeter haMeter);

    public Integer updateMeter(HaMeter haMeter);

    /**
     * 根据centorId查询meter表信息
     * @param centorId 参数centorId
     * @return 返回泛型集合对象
     */
    public List<HaMeter> selectMeterByCentorId(Integer centorId);

    /**
     * 根据CollectorId查询meter表信息
     * @param collectorId 参数CollectorId
     * @return 返回泛型集合对象
     */
    public List<HaMeter> selectMeterByCollectorId(Integer collectorId);

    List<HaMeter> HaMeterList(HaMeter haMeter);

    List<HaMeter> queryHaMeter(Integer areaId,Integer collectorid);

    Integer addHaMeter(HaMeter haMeter);

    Integer updateHaMeter(HaMeter haMeter);

    Integer deleteHaMeter(HaMeter haMeter);
}
