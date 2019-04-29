package com.ktamr.service.impl;

import com.ktamr.domain.HaArea;
import com.ktamr.mapper.HaAreaMapper;
import com.ktamr.service.HaAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小区表实现类
 */
@Service
public class HaAreaServiceImpl implements HaAreaService {

    @Resource
    private HaAreaMapper haAreaMapper;

    @Override
    public List<HaArea> selectAllAreaAndCount(HaArea parms) {
        return haAreaMapper.selectAllAreaAndCount(parms);
    }

    @Override
    public List<HaArea> selectHaAreaIdAndName(HaArea haArea) {
        return haAreaMapper.selectHaAreaIdAndName(haArea);
    }

    @Override
    public List<HaArea> selectAreaIdAreaNoName(HaArea haArea) {
        return haAreaMapper.selectAreaIdAreaNoName(haArea);
    }

    /**
     * 查询小区+分页+条件月份查询
     * @param haArea
     * @param page
     * @param rowNum
     * @return
     */
    @Override
    public List<HaArea> selectHaAreaList(HaArea haArea, Integer page, Integer rowNum) {
        List<HaArea> haAreaList = haAreaMapper.BselectHaAreaList(haArea, page, rowNum);
        if(haAreaList!=null){
            return haAreaList;
        }

        return null;
    }

    /**
     * 查询小区中总记录数
     * @param haArea
     * @return
     */
    @Override
    public Integer selectHaAreaCount(HaArea haArea) {
        List<HaArea> Arealist = haAreaMapper.BselectHaAreaCount(haArea);
        if(Arealist!=null){
            int size = Arealist.size();//这波转化一下把里面的size转化为将要返回的总记录数
            return size;
        }
        return null;
    }

    /**
     * 查询小区表的名字 用于填充条件查询的下拉框
     * @param haArea
     * @return
     */
    @Override
    public List<HaArea> selectHareaNameList(HaArea haArea) {
        List<HaArea> areaList = haAreaMapper.BselectHareaNameList(haArea);
        if(areaList!=null){
            return areaList;
        }
        return null;
    }

    /**
     * 查询大区下的小区名字
     * @param areano
     * @return
     */
    @Override
    public List<HaArea> selectSmallName(String areano) {
        List<HaArea> haAreaList = haAreaMapper.BselectSmallName(areano);
        if(haAreaList!=null){
            return  haAreaList;
        }
        return null;
    }

    /**
     * 根据areaid查询并返回相应的记录数
     * @param haArea
     * @return
     */
    @Override
    public Integer selectCountareaid(HaArea haArea) {
        Integer selectCountareaid = haAreaMapper.BselectCountareaid(haArea);
        if(selectCountareaid!=null){
            return selectCountareaid;
        }
        return null;
    }

    /**
     * 佛系更新小区表
     * @param haArea
     * @return
     */
    @Override
    public Integer updateHaArea(HaArea haArea) {
        Integer updateHaArea = haAreaMapper.BupdateHaArea(haArea);
        if(updateHaArea!=null){
            return updateHaArea;
        }
        return null;
    }

    /**
     * 点击结算上传填充小区根据传入的list集合idsList中的第一个值查询小区名字
     * @param haArea
     * @return
     */
    @Override
    public HaArea selectHaAreaName(HaArea haArea) {
        HaArea selectHaAreaName = haAreaMapper.BselectHaAreaName(haArea);
        if(selectHaAreaName!=null){
            return selectHaAreaName;
        }
        return null;
    }

    /**
     * 点击完成结算第一步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChengJieSuanOne(HaArea haArea) {
        Integer updateWanChengJieSuanOne = haAreaMapper.BupdateWanChengJieSuanOne(haArea);
        if(updateWanChengJieSuanOne!=null){
            return updateWanChengJieSuanOne;
        }
        return null;
    }

    /**
     * 点击完成结算第二步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChenJieSuanTwo(HaArea haArea) {
        Integer updateWanChenJieSuanTwo = haAreaMapper.BupdateWanChenJieSuanTwo(haArea);
        if(updateWanChenJieSuanTwo!=null){
            return updateWanChenJieSuanTwo;
        }
        return null;
    }

    /**
     * 点击完成结算第三步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChenJieSuanThree(HaArea haArea) {
        Integer updateWanChenJieSuanThree = haAreaMapper.BupdateWanChenJieSuanThree(haArea);
        if(updateWanChenJieSuanThree!=null){
            return updateWanChenJieSuanThree;
        }
        return null;
    }

    /**
     * 点击完成结算第四步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChenJieSuanFour(HaArea haArea) {
        Integer updateWanChenJieSuanFour = haAreaMapper.BupdateWanChenJieSuanFour(haArea);
        if(updateWanChenJieSuanFour!=null){
            return updateWanChenJieSuanFour;
        }
        return null;
    }

    /**
     * 点击完成结算第五步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChenJieSuanFive(HaArea haArea) {
        Integer updateWanChenJieSuanFive = haAreaMapper.BupdateWanChenJieSuanFive(haArea);
        if(updateWanChenJieSuanFive!=null){
            return updateWanChenJieSuanFive;
        }
        return null;
    }

    /**
     * 点击完成结算第六步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChenJieSuanSix(HaArea haArea) {
        Integer updateWanChenJieSuanSix = haAreaMapper.BupdateWanChenJieSuanSix(haArea);
        if(updateWanChenJieSuanSix!=null){
            return updateWanChenJieSuanSix;
        }
        return null;
    }

    /**
     * 点击完成结算第七步 即最后一步
     * @param haArea
     * @return
     */
    @Override
    public Integer updateWanChenJieSuanSeven(HaArea haArea) {
        Integer updateWanChenJieSuanSeven = haAreaMapper.BupdateWanChenJieSuanSeven(haArea);
        if (updateWanChenJieSuanSeven!=null){
            return updateWanChenJieSuanSeven;
        }
        return null;
    }

    /**
     * 查询小区表全部信息
     * @return
     */
    @Override
    public List<HaArea> findAllHaArea() {
        return haAreaMapper.BfindAllHaArea();
    }

    @Override
    public List<HaArea> queryAllHaArea() {
        return haAreaMapper.queryAllHaArea();
    }

    @Override
    public Integer addHaArea(HaArea haArea) {
        return haAreaMapper.addHaArea(haArea);
    }

    @Override
    public Integer updateHaArea2(HaArea haArea) {
        return haAreaMapper.updateHaArea2(haArea);
    }

    @Override
    public Integer deleteHaArea(HaArea haArea) {
        return haAreaMapper.deleteHaArea(haArea);
    }

    @Override
    public HaArea updateByIdHaArea(Integer areaid) {
        return haAreaMapper.updateByIdHaArea(areaid);
    }

    @Override
    public Integer queryHaAreaCount(HaArea haArea) {
        return haAreaMapper.queryHaAreaCount(haArea);
    }
}
