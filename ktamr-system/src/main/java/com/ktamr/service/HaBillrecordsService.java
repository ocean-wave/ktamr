package com.ktamr.service;

import com.ktamr.domain.HaBillrecords;

import java.util.List;

public interface HaBillrecordsService {


    /**
     * 收费记录查询
     * @param haBillrecords
     * @return
     */
    public List<HaBillrecords> ChaXunHaBillrecordsList(HaBillrecords haBillrecords);

    /**
     * 收费记录查询总记录数
     * @param haBillrecords
     * @return
     */
    public Integer ChaXunHaBillrecordsCount(HaBillrecords haBillrecords);


    /**
     * 添加收费记录
     * @param haBillrecords
     * @return
     */
    public Integer insertHaBillrecords(HaBillrecords haBillrecords);

    /**
     * 查询用户账单列表
     * @param haBillrecords
     * @return
     */
    public List<HaBillrecords> selectYongHuZhangDan(HaBillrecords haBillrecords);



    /**
     * 检查是否超过可恢复收费
     * @param haBillrecords
     * @return
     */
    public String selectShiFou(HaBillrecords haBillrecords);

}
