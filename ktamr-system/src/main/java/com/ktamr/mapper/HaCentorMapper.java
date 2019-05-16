package com.ktamr.mapper;

import com.ktamr.common.parameter.ParameterInfo;
import com.ktamr.domain.HaCentor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 接口Mapper层
 */
public interface HaCentorMapper {
    /**
     * 查询集中器信息并且统计总表数、读入表数、建档表数、无返回表数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    public List<HaCentor> selectAllCentorzAndCount(HaCentor parms);

    /**
     * 查询集中器信息并且统计上期结算、最近读数、本期用量
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    public List<HaCentor> selectAllCentorzQueryIdAndCount(HaCentor parms);

    /**
     * 根据centorId进行查询集中器信息并且统计表总数、读入表数、建档状态数、无返回表数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    public List<HaCentor> selectAllCentorzByIdAndCount(HaCentor parms);

    /**
     * 查询集采器信息并且统计总表数、读入表数、建档表数、无返回表数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    public List<HaCentor> selectAllCentorcAndCount(HaCentor parms);

    /**
     * 查询手抄器信息并且统计总表数、读入表数、建档状态数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    public List<HaCentor> selectAllCentorHandAndCount(HaCentor parms);


    public List<HaCentor> selectCentor(HaCentor haCentor);

    List<HaCentor> HaCentorList(@Param("haCentor") HaCentor haCentor);

    List<HaCentor> deviceTypeList(@Param("haCentor") HaCentor haCentor);

    Integer addHaCentor(HaCentor haCentor);

    Integer updateHaCentor(HaCentor haCentor);

    Integer deleteHaCentor(HaCentor haCentor);
}
