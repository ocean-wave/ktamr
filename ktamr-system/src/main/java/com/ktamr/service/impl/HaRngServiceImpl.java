package com.ktamr.service.impl;

import com.ktamr.domain.HaRgn;
import com.ktamr.mapper.HaRngMapper;
import com.ktamr.service.HaRngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 大区表实现类
 */
@Service
public class HaRngServiceImpl implements HaRngService {

    @Autowired
    private HaRngMapper haRngMapper;

    /**
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量
     * @return
     */
    @Override
    public List<HaRgn> selectAllRngAndCount(HaRgn haRgn) {         //实现模糊查询并且进行两个字段查询
        return haRngMapper.selectAllRngAndCount(haRgn);
    }

    /**
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量
     * @return
     */
    @Override
    public List<HaRgn> selectAllRngAndCount() {
        return haRngMapper.selectAllRngAndCount();
    }

    /**
     * 查询大区表的名字
     * @return
     */
    @Override
    public List<HaRgn> selectBigName() {
        List<HaRgn> haRgnList = haRngMapper.selectBigName();
        if(haRgnList!=null){
            return haRgnList;
        }
        return null;
    }


    /**
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量
     *
     * @return
     */

    public List<HaRgn> selectAllRngAndCount(HaRgn haRgn, Integer page, Integer rowNum) {
        return haRngMapper.selectAllRngAndCount(haRgn,page,rowNum);
    }

    @Override
    public List<HaRgn> queryAllRng() {
        return haRngMapper.queryAllRng();
    }

    @Override
    public HaRgn updateByIdRng(HaRgn haRgn) {
        return haRngMapper.updateByIdRng(haRgn);
    }

    @Override
    public Integer HaRgnCount(HaRgn haRgn) {
        Integer haRgnCount = haRngMapper.HaRgnCount(haRgn);
        if(haRgnCount!=null){
            return  haRgnCount;
        }
        return null;
    }

    @Override
    public Integer addHaRgn(HaRgn haRgn) {
        return haRngMapper.addHaRgn(haRgn);
    }

    @Override
    public Integer updateHaRgn(HaRgn haRgn) {
        return haRngMapper.updateHaRgn(haRgn);
    }

    @Override
    public Integer deleteHaRgn(HaRgn haRgn) {
        return haRngMapper.deleteHaRgn(haRgn);
    }

    @Override
    public Integer count0() {
        return haRngMapper.count0();
    }

    @Override
    public Integer countA() {
        return haRngMapper.countA();
    }

    @Override
    public Integer countla() {
        return haRngMapper.countla();
    }

    @Override
    public Integer countNumber() {
        return haRngMapper.countNumber();
    }

    @Override
    public Integer countUpperCase() {
        return haRngMapper.countUpperCase();
    }

    @Override
    public String elseId() {
        return haRngMapper.elseId();
    }
}
