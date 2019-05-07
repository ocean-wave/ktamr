package com.ktamr.mapper;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaMeter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 表具资料表Mapper
 */
public interface HaMeterMapper {

    public List<Map<String,Object>> selectAllMeter(Map<String, Object> parms);

    public Map<String,Object> selectMeterById(Integer meterid);

    public Map<String,Object> selectMeterAndBuildingById(Integer meterid);

    public List<Map<String,Object>> selectDosageRecently(ParameterInfo params);

    public List<Map<String,Object>> selectDosageHistory(ParameterInfo params);

    public List<Map<String,Object>> selectNotok(ParameterInfo params);

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

    List<HaMeter> queryHaMeter(@Param("areaId") Integer areaId, @Param("collectorid") Integer collectorid);

    Integer addHaMeter(HaMeter haMeter);

    Integer updateHaMeter(HaMeter haMeter);

    Integer deleteHaMeter(HaMeter haMeter);
}
