package com.ktamr.mapper;

import com.ktamr.domain.HatDevicesimport;

import java.util.List;

public interface HatDevicesimportMapper {

    List<HatDevicesimport> HatDevicesimportList(HatDevicesimport hatDevicesimport);

    //新增导入设备(待校验)
    Integer addHatDevicesimport(HatDevicesimport hatDevicesimport);

    //修改设备档案
    Integer updateHatDevicesimport(HatDevicesimport hatDevicesimport);

    //清理零时表
    Integer deleteHatDevicesimport(HatDevicesimport hatDevicesimport);

    //所属小区校验
    Integer belongAreaCheck(HatDevicesimport hatDevicesimport);

    //连接说明校验
    Integer joinSayCheck(HatDevicesimport hatDevicesimport);

    //设备名称校验
    Integer centorNameCheck(HatDevicesimport hatDevicesimport);

    //设备地址校验1
    Integer centorAddrCheck1(HatDevicesimport hatDevicesimport);

    //设备地址校验2
    Integer centorAddrCheck2(HatDevicesimport hatDevicesimport);

    //设备地址校验3
    Integer centorAddrCheck3(HatDevicesimport hatDevicesimport);

    //设备地址校验4
    Integer centorAddrCheck4(HatDevicesimport hatDevicesimport);

    //设备地址校验5
    Integer centorAddrCheck5(HatDevicesimport hatDevicesimport);

    //设备地址校验6
    Integer centorAddrCheck6(HatDevicesimport hatDevicesimport);

    //判断是新增还是修改
    Integer checkAddOrUpdate(HatDevicesimport hatDevicesimport);

    //补齐默认数值
    Integer completeDefaultValues(HatDevicesimport hatDevicesimport);

    //查询总条目
    Integer queryAllHatDevicesimportCount(HatDevicesimport hatDevicesimport);

    //查询新增数
    Integer addsCount(HatDevicesimport hatDevicesimport);

    //查询修改数
    Integer updsCount(HatDevicesimport hatDevicesimport);

    //新增设备档案——新增集中器档案和手抄线路档案
    Integer addCentorsAndHandDevices(HatDevicesimport hatDevicesimport);
}
