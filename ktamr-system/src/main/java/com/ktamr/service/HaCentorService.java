package com.ktamr.service;

import com.ktamr.domain.HaCentor;

import java.util.List;

/**
 * 接口Service层
 */
public interface HaCentorService {
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

    /**
     * nb单表
     * @param parms
     * @return
     */
    public List<HaCentor> selectNbSurfaceCollector(HaCentor parms);

    public List<HaCentor> selectCentor(HaCentor haCentor);

    List<HaCentor> HaCentorList(HaCentor haCentor);

    HaCentor updateByIdHaCentor(Integer id);

    HaCentor queryAddr(Integer id);

    Integer addHaCentor(HaCentor haCentor);

    Integer updateHaCentor(HaCentor haCentor);

    Integer deleteHaCentor(Integer id);

    //设备类型为centor下拉框
    List<HaCentor> deviceTypeCentor();

    //设备类型为ccentor下拉框
    List<HaCentor> deviceTypeCcentor();

    //设备类型为handDevice下拉框
    List<HaCentor> deviceTypehandDevice();

    //查看抄收设备
    HaCentor updateByDeviceType(Integer id);

    //修改时集中器传值
    List<HaCentor> DeviceByWhere(HaCentor haCentor);

    HaCentor centorDevNo(Integer centorId);

    HaCentor centorDevDescription(Integer centorId);

    //查询集中器超收，根据登录用户id查询
    public Integer centor_count( String  operator_codeSession);

    //查询集采器超收，根据登录用户id查询
    public Integer collector_count( String operator_codeSession);

    //查询手抄器超收，根据登录用户id查询 1线路列表
    public Integer pad_count1( String operator_codeSession);

    //查询手抄器抄收，根据登录用户id查询 2表列表
    public Integer pad_count2( String operator_codeSession);

    //查询DTU，根据登录用户id查询
    public Integer DTU_count( String operator_codeSession);

}
