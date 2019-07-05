package com.ktamr.service.impl;

import com.ktamr.domain.HaBillrecords;
import com.ktamr.mapper.HaBillrecordsMapper;
import com.ktamr.service.HaBillrecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaBillrecordsServiceImpl implements HaBillrecordsService {

    @Autowired
    private HaBillrecordsMapper haBillrecordsMapper;

    /**
     * 收费纪录的查询
     * @param haBillrecords
     * @return
     */
    @Override
    public List<HaBillrecords> ChaXunHaBillrecordsList(HaBillrecords haBillrecords) {
        List<HaBillrecords> haBillrecordsList = haBillrecordsMapper.ChaXunHaBillrecordsList(haBillrecords);
        if(haBillrecordsList!=null){
            return  haBillrecordsList;
        }

        return null;
    }

    /***
     * 收费纪录的查询总记录数
     * @param haBillrecords
     * @return
     */
    @Override
    public Integer ChaXunHaBillrecordsCount(HaBillrecords haBillrecords) {
        Integer count = haBillrecordsMapper.ChaXunHaBillrecordsCount(haBillrecords);
        if(count!=null){
            return  count;
        }
        return null;
    }

    /**
     * 添加收费记录
     * @param haBillrecords
     * @return
     */
    @Override
    public Integer insertHaBillrecords(HaBillrecords haBillrecords) {
        Integer insertHaBillrecords = haBillrecordsMapper.insertHaBillrecords(haBillrecords);
        if(insertHaBillrecords!=null){
            return insertHaBillrecords;
        }
        return null;
    }

    /**
     * 查询用户账单列表
     * @param haBillrecords
     * @return
     */
    @Override
    public List<HaBillrecords> selectYongHuZhangDan(HaBillrecords haBillrecords) {
        List<HaBillrecords> haBillrecordsList = haBillrecordsMapper.selectYongHuZhangDan(haBillrecords);
        if(haBillrecordsList!=null){
            return haBillrecordsList;
        }
        return null;
    }


    /**
     * 检查是否超过可恢复收费
     * @param haBillrecords
     * @return
     */
    @Override
    public String selectShiFou(HaBillrecords haBillrecords) {
        String shiFou = haBillrecordsMapper.selectShiFou(haBillrecords);
        if(shiFou!=null){
            return shiFou;
        }
        return null;
    }


}
