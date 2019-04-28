package com.ktamr.mapper;

import com.ktamr.domain.HaArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  小区表Mapper
 */
public interface HaAreaMapper {

    public List<HaArea> selectAllAreaAndCount(HaArea parms);

    public List<HaArea> selectHaAreaIdAndName(HaArea haArea);

    public List<HaArea> selectAreaIdAreaNoName(HaArea haArea);

    /**
     * 查询小区表
     * @param haArea
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaArea> selectHaAreaList(@Param("HaArea") HaArea haArea, @Param("page") Integer page,
                                         @Param("rowNum") Integer rowNum);


    /**
     * 查询小区表总记录数 先返回泛型集合 在获取里面的size
     * @param haArea
     * @return
     */
    public List<HaArea> selectHaAreaCount(@Param("HaArea") HaArea haArea);

    /**
     * 查询小区表名字 填充条件查询的下拉框
     * @param haArea
     * @return
     */
    public List<HaArea> selectHareaNameList(HaArea haArea);


    /**
     * 根据areano查询大区下的小区的名字
     * @param areano
     * @return
     */
    public List<HaArea> selectSmallName(@Param("areano") String areano);


    /**
     * 根据areaid查询并返回相应的记录数
     * @param haArea
     * @return
     */
    public Integer selectCountareaid(HaArea haArea);

    /**
     * 佛系更新小区表
     * @param haArea
     * @return
     */
    public Integer updateHaArea(HaArea haArea);

    /**
     * 点击结算上传填充小区根据传入的list集合idsList中的第一个值查询小区名字
     * @param haArea
     * @return
     */
    public HaArea selectHaAreaName(HaArea haArea);

    /**
     * 点击完成结算第一步
     * @param haArea
     * @return
     */
    public Integer updateWanChengJieSuanOne(HaArea haArea);

    /**
     * 点击完成结算第二步
     * @param haArea
     * @return
     */
    public Integer updateWanChenJieSuanTwo(HaArea haArea);

    /**
     * 点击完成结算第三步
     * @param haArea
     * @return
     */
    public Integer updateWanChenJieSuanThree(HaArea haArea);

    /**
     * 点击完成结算第四步
     * @param haArea
     * @return
     */
    public Integer updateWanChenJieSuanFour(HaArea haArea);

    /**
     * 点击完成结算第五步
     * @param haArea
     * @return
     */
    public Integer updateWanChenJieSuanFive(HaArea haArea);

    /**
     * 点击完成结算第六步
     * @param haArea
     * @return
     */
    public Integer updateWanChenJieSuanSix(HaArea haArea);

    /**
     * 点击完成结算第七步 即最后一步
     * @param haArea
     * @return
     */
    public Integer updateWanChenJieSuanSeven(HaArea haArea);


    /*
       查询全部
        */
    public List<HaArea> findAllHaArea();

    Integer addHaArea(HaArea haArea);

    Integer updateHaArea2(@Param("haArea") HaArea haArea);

    Integer deleteHaArea(@Param("haArea") HaArea haArea);

    List<HaArea> queryAllHaArea();

    HaArea updateByIdHaArea(@Param("areaid") Integer areaid);

    Integer queryHaAreaCount(HaArea haArea);
}
