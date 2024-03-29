package com.ktamr.service;

import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaCollector;
import com.ktamr.domain.HaMeter;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 表具资料表Service
 */
public interface HaMeterService {

    public Integer updateMeter(HaMeter haMeter);

    public Integer updateMeterTwo(String importTime);

    public Map<String,Object> selectMeterById(Integer meterid);

    /**
     * 查询表具资料表与房间表信息
     * @param meterId 根据id查询
     * @return 返回对象
     */
    public HaMeter selectMeterAndBuildingById(Integer meterId);

    /**
     *
     * @param
     * @return
     */
    public HaMeter selectMeterAndBuildingByKeyWordTwo(String keyWordTwo);

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

    public List<HaMeter> selectRecordByHand(HaMeter haMeter);

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

    List<HaMeter> queryHaMeter(Integer centorId,Integer collectorId);

    Integer HaMeterCount(HaMeter haMeter);

    Integer addHaMeter(HaMeter haMeter);

    Integer updateHaMeter(HaMeter haMeter);

    //采集器选择表
    Integer updateHaMeterCollector(HaMeter haMeter, HaCentor haCentor, HaCollector haCollector);

    //采集器选择表关联成功记录数
    Integer HaMeterCollectorCount(Integer centorId,Integer collectorId,Integer meterIds);

    //线路选择表
    Integer updateHaMeterReadLine(HaMeter haMeter,HaCentor haCentor,Integer readLineId);

    //线路选择表关联成功记录数
    Integer HaMeterReadLineCount(Integer readLineId,Integer meterIds);

    //都不是 centorId < 0 && collectorId < 0 或 readLineId < 0
    Integer updateHaMeterNull(HaMeter haMeter);

    //空关联成功记录数
    Integer HaMeterNullCount(Integer meterIds);

    //删除价格列表时判断收费标准是否在使用
    Integer isPriceUsed(Integer id);

    Integer deleteHaMeter(HaMeter haMeter);

    HaMeter delByIdHaMeter(HaMeter haMeter);

    //安装表数量
    Integer meterCountNum(Integer roomId);

    //原表底数
    HaMeter orIgNumber(Integer meterId);

    //原表号
    HaMeter orImeterNumber(Integer meterId);

    HaMeter mMeterSequence(@Param("meterId") Integer meterId);

    HaMeter mMeterSequence2(@Param("centorId") Integer centorId,@Param("centorId2") Integer centorId2);

    /**
     * 主页统计表==》表列表
     * @param haMeter
     * @param page
     * @param rowNum
     * @return 全部数据List集合
     */
    public List<HaMeter> zhuYegetStateMeter(@Param("HaMeter") HaMeter haMeter, @Param("page") Integer page,
                                            @Param("rowNum") Integer rowNum);

    /**
     * 主页统计表==》表列表
     * @param haMeter
     * @return 全部数据的总记录数
     */
    public Integer zhuYegetStateMeterCount(@Param("HaMeter") HaMeter haMeter);

    //replace meter
    Integer replaceMeter(HaMeter haMeter);

    Integer replaceMeter3(HaMeter haMeter);

    List<HaMeter> getRowIdMeter(HaMeter haMeter);

    //没有抄收过
    Integer noCheck(Integer meterId);

    //'抄收过，没有结算过，修改表底数同时会修改期初读数
    Integer checkButNoSettlement(String startTime,double gnumber,double lfNumber,Integer meterId);

    Integer updateNullRoomId(Integer meterId);

    Integer updateNullRoomId2(@Param("roomId") Integer roomId,@Param("areaId") Integer areaId,@Param("meterId") Integer meterId);
}
