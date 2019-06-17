package com.ktamr.service.impl;

import com.ktamr.domain.HaCentor;
import com.ktamr.mapper.HaCentorMapper;
import com.ktamr.service.HaCentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现层(HaCentorServiceImpl)
 */
@Service
public class HaCentorServiceImpl implements HaCentorService {

    /**
     * 注入haCentorMapper
     */
    @Autowired
    private HaCentorMapper haCentorMapper;

    /**
     * 查询集中器信息并且统计总表数、读入表数、建档表数、无返回表数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    @Override
    public List<HaCentor> selectAllCentorzAndCount(HaCentor parms) {
        return haCentorMapper.selectAllCentorzAndCount(parms);
    }

    /**
     * 查询集中器信息并且统计上期结算、最近读数、本期用量
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    @Override
    public List<HaCentor> selectAllCentorzQueryIdAndCount(HaCentor parms) {
        return haCentorMapper.selectAllCentorzQueryIdAndCount(parms);
    }

    /**
     * 根据centorId进行查询集中器信息并且统计表总数、读入表数、建档状态数、无返回表数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    @Override
    public List<HaCentor> selectAllCentorzByIdAndCount(HaCentor parms) {
        return haCentorMapper.selectAllCentorzByIdAndCount(parms);
    }

    /**
     * 查询集采器信息并且统计总表数、读入表数、建档表数、无返回表数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    @Override
    public List<HaCentor> selectAllCentorcAndCount(HaCentor parms) {
        return haCentorMapper.selectAllCentorcAndCount(parms);
    }

    /**
     * 查询手抄器信息并且统计总表数、读入表数、建档状态数
     * @param parms 对象参数
     * @return 返回对象泛型集合
     */
    @Override
    public List<HaCentor> selectAllCentorHandAndCount(HaCentor parms) {
        return haCentorMapper.selectAllCentorHandAndCount(parms);
    }

    @Override
    public List<HaCentor> selectCentor(HaCentor haCentor) {
        return haCentorMapper.selectCentor(haCentor);
    }

    public List<HaCentor> HaCentorList(HaCentor haCentor) {
        return haCentorMapper.HaCentorList(haCentor);
    }

    @Override
    public HaCentor updateByIdHaCentor(Integer id) {
        return haCentorMapper.updateByIdHaCentor(id);
    }

    @Override
    public HaCentor queryAddr(Integer id) {
        return haCentorMapper.queryAddr(id);
    }

    public Integer addHaCentor(HaCentor haCentor) {
        return haCentorMapper.addHaCentor(haCentor);
    }

    public Integer updateHaCentor(HaCentor haCentor) {
        return haCentorMapper.updateHaCentor(haCentor);
    }

    public Integer deleteHaCentor(Integer id) {
        return haCentorMapper.deleteHaCentor(id);
    }

    @Override
    public List<HaCentor> deviceTypeCentor() {
        return haCentorMapper.deviceTypeCentor();
    }

    @Override
    public List<HaCentor> deviceTypeCcentor() {
        return haCentorMapper.deviceTypeCcentor();
    }

    @Override
    public List<HaCentor> deviceTypehandDevice() {
        return haCentorMapper.deviceTypehandDevice();
    }

    @Override
    public HaCentor updateByDeviceType(Integer id) {
        return haCentorMapper.updateByDeviceType(id);
    }

    @Override
    public List<HaCentor> DeviceByWhere(String deviceType) {
        return haCentorMapper.DeviceByWhere(deviceType);
    }

    /**
     * 查询集中器超收，根据登录用户id查询
     * @param operator_codeSession
     * @return
     */
    @Override
    public Integer centor_count(String operator_codeSession) {
        Integer centor_count = haCentorMapper.centor_count(operator_codeSession);
        if(centor_count!=null){
            return  centor_count;
        }
        return null;
    }

    /**
     * 查询集采器超收，根据登录用户id查询
     * @param operator_codeSession
     * @return
     */
    @Override
    public Integer collector_count(String operator_codeSession) {
        Integer collector_count = haCentorMapper.collector_count(operator_codeSession);
        if(collector_count!=null){
            return collector_count;
        }
        return null;
    }

    /**
     * 查询手抄器超收，根据登录用户id查询 1线路列表
     * @param operator_codeSession
     * @return
     */
    @Override
    public Integer pad_count1(String operator_codeSession) {
        Integer pad_count1 = haCentorMapper.pad_count1(operator_codeSession);
        return null;
    }

    /**
     * 查询手抄器抄收，根据登录用户id查询 2表列表
     * @param operator_codeSession
     * @return
     */
    @Override
    public Integer pad_count2(String operator_codeSession) {
        Integer pad_count2 = haCentorMapper.pad_count2(operator_codeSession);
        if(pad_count2!=null){
            return pad_count2;
        }
        return null;
    }

    /**
     * 查询DTU，根据登录用户id查询
     * @param operator_codeSession
     * @return
     */
    @Override
    public Integer DTU_count(String operator_codeSession) {
        Integer dtu_count = haCentorMapper.DTU_count(operator_codeSession);
        if(dtu_count!=null){
            return dtu_count;
        }
        return null;
    }
}
