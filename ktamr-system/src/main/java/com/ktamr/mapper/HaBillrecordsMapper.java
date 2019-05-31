package com.ktamr.mapper;

import com.ktamr.domain.HaBillrecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HaBillrecordsMapper {

    /**
     * 收费记录查询
     * @param haBillrecords
     * @return
     */
    public List<HaBillrecords> ChaXunHaBillrecordsList(@Param("HaBillrecords") HaBillrecords haBillrecords
    );

    /**
     * 查询收费记录的记录数
     * @param haBillrecords
     * @return
     */
    public Integer ChaXunHaBillrecordsCount(@Param("HaBillrecords") HaBillrecords haBillrecords);

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
    public List<HaBillrecords> selectYongHuZhangDan(@Param("HaBillrecords") HaBillrecords haBillrecords);



    /**
     * 检查是否超过可恢复收费
     * @param haBillrecords
     * @return
     */
    public String selectShiFou(HaBillrecords haBillrecords);

}
