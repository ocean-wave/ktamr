package com.ktamr.mapper;

import com.ktamr.domain.HaCentor;
import com.ktamr.domain.HaCollector;
import com.ktamr.domain.HaMeter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 表具资料表Mapper
 */
public interface HaMeterMapper {

    public Map<String,Object> selectMeterById(Integer meterid);

    /**
     * 查询表具资料表与房间表信息
     * @param meterId 根据id查询
     * @return 返回对象
     */
    public HaMeter selectMeterAndBuildingById(Integer meterId);

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


    List<HaMeter> HaMeterList(@Param("haMeter") HaMeter haMeter,@Param("page") Integer page,
                              @Param("rowNum") Integer rowNum);

    List<HaMeter> queryHaMeter(@Param("centorId") Integer centorId, @Param("collectorId") Integer collectorId,@Param("page") Integer page,
                               @Param("rowNum") Integer rowNum);

    Integer HaMeterCount(HaMeter haMeter);

    Integer addHaMeter(HaMeter haMeter);

    Integer updateHaMeter(HaMeter haMeter);

    //删除价格列表时判断收费标准是否在使用
    Integer isPriceUsed(@Param("id") Integer id);


    //采集器选择表,端口选择表
    Integer updateHaMeterCollector(@Param("haMeter") HaMeter haMeter,@Param("haCentor") HaCentor haCentor,@Param("haCollector") HaCollector haCollector);

    //采集器选择表,端口选择表关联成功记录数
    Integer HaMeterCollectorCount(@Param("centorId") Integer centorId,@Param("collectorId") Integer collectorId,@Param("meterIds") Integer meterIds);

    //线路选择表
    Integer updateHaMeterReadLine(@Param("haMeter") HaMeter haMeter,@Param("haCentor") HaCentor haCentor,@Param("readLineId") Integer readLineId);

    //线路选择表关联成功记录数
    Integer HaMeterReadLineCount(@Param("readLineId") Integer readLineId,@Param("meterIds") Integer meterIds);

    //都不是 centorId < 0 && collectorId < 0 或 readLineId < 0
    Integer updateHaMeterNull(@Param("haMeter") HaMeter haMeter);

    //空关联成功记录数
    Integer HaMeterNullCount(@Param("meterIds") Integer meterIds);

    Integer deleteHaMeter(HaMeter haMeter);

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
}
