package com.ktamr.mapper;

import com.ktamr.common.core.domain.BaseEntity;
import com.ktamr.domain.HaArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 小区表Mapper
 */
public interface HaAreaMapper {

    /**
     * 查询小区信息并且统计总表叔、总读数、本期总用量、不良表数
     * @param parms 对象参数
     * @return 返回泛型集合
     */
    public List<HaArea> selectAllAreaAndCount(HaArea parms);

    /**
     * 查询小区id与名称
     * @param haArea 对象参数
     * @return 返回泛型集合
     */
    public List<HaArea> selectHaAreaIdAndName(HaArea haArea);

    /**
     * 在主页概况中统计图根据状态查询一波
     * @param haArea
     * @return 返回泛型集合
     */
    public List<HaArea> AQueryHaAreabystatus(@Param("HaArea") HaArea haArea, @Param("page") Integer page,
                                             @Param("rowNum") Integer rowNum);

    /**
     * 在主页概况中统计图根据状态总记录数查询一波
     * @param haArea
     * @return 返回Integer整数值
     */
    public List<HaArea> AQueryHaAreabystatusCount(@Param("HaArea") HaArea haArea);

    /**
     * 查询小区表
     * @param baseEntity
     * @return
     */
    public List<HaArea> BselectHaAreaList(BaseEntity baseEntity);



    /**
     * 查询小区表名字 填充条件查询的下拉框
     *
     * @param haArea
     * @return
     */
    public List<HaArea> BselectHareaNameList(HaArea haArea);


    /**
     * 根据areano查询大区下的小区的名字
     *
     * @param areano
     * @return
     */
    public List<HaArea> BselectSmallName(@Param("areano") String areano);


    /**
     * 根据areaid查询并返回相应的记录数
     *
     * @param haArea
     * @return
     */
    public Integer BselectCountareaid(HaArea haArea);

    /**
     * 佛系更新小区表
     *
     * @param haArea
     * @return
     */
    public Integer BupdateHaArea(HaArea haArea);

    /**
     * 点击结算上传填充小区根据传入的list集合idsList中的第一个值查询小区名字
     *
     * @param haArea
     * @return
     */
    public HaArea BselectHaAreaName(HaArea haArea);

    /**
     * 点击完成结算第一步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChengJieSuanOne(HaArea haArea);

    /**
     * 点击完成结算第二步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChenJieSuanTwo(HaArea haArea);

    /**
     * 点击完成结算第三步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChenJieSuanThree(HaArea haArea);

    /**
     * 点击完成结算第四步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChenJieSuanFour(HaArea haArea);

    /**
     * 点击完成结算第五步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChenJieSuanFive(HaArea haArea);

    /**
     * 点击完成结算第六步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChenJieSuanSix(HaArea haArea);

    /**
     * 点击完成结算第七步 即最后一步
     *
     * @param haArea
     * @return
     */
    public Integer BupdateWanChenJieSuanSeven(HaArea haArea);


    /*
     *查询全部
     */
    public List<HaArea> BfindAllHaArea();




    /*
     *新增小区
     */
    Integer addHaAreaC(HaArea haArea);

    /*
     *修改小区
     */
    Integer updateHaAreaC(@Param("haArea") HaArea haArea);

    /*
     *删除小区
     */
    Integer deleteHaAreaC(@Param("haArea") HaArea haArea);

    /*
     *小区下拉框
     */
    List<HaArea> queryAllHaAreaC();

    /*
     *修改小区传值
     */
    HaArea updateByIdHaAreaC(@Param("areaId") Integer areaId);

    /*
     *小区记录数
     */
    Integer queryHaAreaCountC(HaArea haArea);

    /*
     *显示全部小区
     */
    List<HaArea> queryAllSmallArea(@Param("haArea") HaArea haArea);

    /*
     *根据大区id显示小区
     */
    List<HaArea> queryAllSmallArea2(@Param("areaNo") String areaNo);

    /*
     *大区下所属小区记录数
     */
    Integer smallAreaCount(HaArea haArea);

    /*
     *拿到areaId
     */
    HaArea getAreaId(@Param("deviceId") Integer deviceId);

    //选择区域类型为小区，选择小区下区域
    List<HaArea> queryAreaByArea();

    //删除大区时看下属小区记录数
    Integer delRgnAreaCount(@Param("id") String id);

}
