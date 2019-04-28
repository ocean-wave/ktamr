package com.ktamr.service;

import com.ktamr.domain.HaBillrecords;

import java.util.List;

public interface HaBillrecordsService {


    /**
     * 收费记录查询
     * @param haBillrecords
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaBillrecords> queryHaBillrecordsList(HaBillrecords haBillrecords,
                                                      Integer page,
                                                      Integer rowNum);

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
     * @param page
     * @param rowNum
     * @return
     */
    public List<HaBillrecords> selectYongHuZhangDan(HaBillrecords haBillrecords,
                                                    Integer page,
                                                    Integer rowNum
    );

    /**
     * 查询用户账单列表记录数
     * @param haBillrecords
     * @return
     */
    public Integer selectYongHuZhangDanCount(HaBillrecords haBillrecords);

    /**
     * 检查是否超过可恢复收费
     * @param haBillrecords
     * @return
     */
    public String selectShiFou(HaBillrecords haBillrecords);

}
