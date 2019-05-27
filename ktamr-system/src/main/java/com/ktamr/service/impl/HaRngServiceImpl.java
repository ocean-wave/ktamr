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
     * 查询大区表全部信息与小区,集中器,采集器数,表数的数量  B
     * @return
     */
    @Override
    public List<HaRgn> selectAllRngAndCountB() {
        return haRngMapper.selectAllRngAndCountB();
    }

    /**
     * 查询大区表的名字
     * @return
     */
    @Override
    public List<HaRgn> selectBigNameB() {
        List<HaRgn> haRgnList = haRngMapper.selectBigNameB();
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

    public List<HaRgn> selectAllRngAndCountC(HaRgn haRgn, Integer page, Integer rowNum) {
        return haRngMapper.selectAllRngAndCountC(haRgn,page,rowNum);
    }

    /**
     * 大区下拉框
     * @return
     */
    @Override
    public List<HaRgn> queryAllRngC() {
        return haRngMapper.queryAllRngC();
    }

    /**
     * 修改大区传值
     * @return
     */
    @Override
    public HaRgn updateByIdRngC(HaRgn haRgn) {
        return haRngMapper.updateByIdRngC(haRgn);
    }

    /**
     * 记录数
     * @return
     */
    @Override
    public Integer HaRgnCountC(HaRgn haRgn) {
        Integer haRgnCount = haRngMapper.HaRgnCountC(haRgn);
        if(haRgnCount!=null){
            return  haRgnCount;
        }
        return null;
    }

    /**
     * 添加大区
     * @return
     */
    @Override
    public Integer addHaRgnC(HaRgn haRgn) {
        return haRngMapper.addHaRgnC(haRgn);
    }

    /**
     * 修改大区
     * @return
     */
    @Override
    public Integer updateHaRgnC(HaRgn haRgn) {
        return haRngMapper.updateHaRgnC(haRgn);
    }

    /**
     * 删除大区
     * @return
     */
    @Override
    public Integer deleteHaRgnC(HaRgn haRgn) {
        return haRngMapper.deleteHaRgnC(haRgn);
    }

    /**
     * 新增大区前判断id
     * @return
     */
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

    /**
     * 节点-所有大区
     * @return
     */
    @Override
    public List<HaRgn> queryAllBigAreaC() {
        return haRngMapper.queryAllBigAreaC();
    }

    @Override
    public List<HaRgn> queryRgnByRgn() {
        return haRngMapper.queryRgnByRgn();
    }
}
