package com.ktamr.mapper;

import com.ktamr.domain.HaReplacerecords;
import com.ktamr.domain.HaRgn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 换表记录表Mapper
 */
public interface HaReplaceRecordsMapper {

    /**
     * 查询换表记录表信息
     * @param haReplacerecords 对象参数
     * @return 返回泛型对象集合
     */
    public List<HaReplacerecords> selectReplace(HaReplacerecords haReplacerecords);

}
