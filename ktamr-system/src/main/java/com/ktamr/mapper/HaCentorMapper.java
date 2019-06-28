package com.ktamr.mapper;
import com.ktamr.domain.HaCentor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * nb单表
     * @param parms
     * @return
     */
    public List<HaCentor> selectNbSurfaceCollector(HaCentor parms);


    public List<HaCentor> selectCentor(HaCentor haCentor);

    List<HaCentor> HaCentorList(@Param("haCentor") HaCentor haCentor);

    List<HaCentor> deviceTypeList(@Param("haCentor") HaCentor haCentor);

    HaCentor queryAddr(@Param("id") Integer id);

    HaCentor updateByIdHaCentor(@Param("id") Integer id);

    Integer addHaCentor(HaCentor haCentor);

    Integer updateHaCentor(HaCentor haCentor);

    Integer deleteHaCentor(@Param("id") Integer id);

    //设备类型为centor下拉框
    List<HaCentor> deviceTypeCentor();

    //设备类型为ccentor下拉框
    List<HaCentor> deviceTypeCcentor();

    //设备类型为handDevice下拉框
    List<HaCentor> deviceTypehandDevice();

    //查看抄收设备
    HaCentor updateByDeviceType(@Param("id") Integer id);

    //修改时集中器传值
    List<HaCentor> DeviceByWhere(@Param("deviceType") String deviceType);

    HaCentor centorDevNo(@Param("centorId") Integer centorId);

    HaCentor centorDevDescription(@Param("centorId") Integer centorId);

    //查询集中器超收，根据登录用户id查询
    public Integer centor_count(@Param("operator_codeSession") String  operator_codeSession);

    //查询集采器超收，根据登录用户id查询
    public Integer collector_count(@Param("operator_codeSession") String operator_codeSession);

    //查询手抄器超收，根据登录用户id查询 1线路列表
    public Integer pad_count1(@Param("operator_codeSession") String operator_codeSession);

    //查询手抄器抄收，根据登录用户id查询 2表列表
    public Integer pad_count2(@Param("operator_codeSession") String operator_codeSession);

    //查询DTU，根据登录用户id查询
    public Integer DTU_count(@Param("operator_codeSession") String operator_codeSession);


}
