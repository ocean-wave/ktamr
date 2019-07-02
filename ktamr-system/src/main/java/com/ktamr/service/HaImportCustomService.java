package com.ktamr.service;

import com.ktamr.domain.HaImportcustom;
import com.ktamr.domain.HaMetertype;
import com.ktamr.domain.HaPricestandard;

import java.util.List;
import java.util.Map;

public interface HaImportCustomService {

    List<HaImportcustom> HaImportcustomList(HaImportcustom haImportcustom);

    //新增用户资料零时表(待校验)
    Integer addImportCustom(List<Map<String, Object>> params);

    //清空导入用户资料零时表
    Integer deleteImportCustom(HaImportcustom haImportcustom);

    //校验用户资料临时表数据
    Integer checkCustomTemporary(HaImportcustom haImportcustom);

    //整理数据
    Integer collationData(HaImportcustom haImportcustom);

    //用户地址校验1
    Integer customAddrCheck1(HaImportcustom haImportcustom);

    //用户地址校验2
    Integer customAddrCheck2(HaImportcustom haImportcustom);

    //用户地址校验3
    Integer customAddrCheck3(HaImportcustom haImportcustom);

    //用户地址校验4
    Integer customAddrCheck4(HaImportcustom haImportcustom);

    //用户地址校验5
    Integer customAddrCheck5(HaImportcustom haImportcustom);

    //用户地址校验6
    Integer customAddrCheck6(HaImportcustom haImportcustom);

    //用户地址校验7
    Integer customAddrCheck7(HaImportcustom haImportcustom);

    //用户地址校验8
    Integer customAddrCheck8(HaImportcustom haImportcustom);

    //用户编号校验1
    Integer customNoCheck1(HaImportcustom haImportcustom);

    //用户编号校验2
    Integer customNoCheck2(HaImportcustom haImportcustom);

    //导入房间用户编号 系统已有房间使用
    Integer customNoCheck3(HaImportcustom haImportcustom);

    //导入新房间用户编号已有房间使用
    Integer customNoCheck4(HaImportcustom haImportcustom);

    //表号校验1
    Integer meterNumCheck1(HaImportcustom haImportcustom);

    //表号校验1
    Integer meterNumCheck2(HaImportcustom haImportcustom);

    //表号校验1
    Integer meterNumCheck3(HaImportcustom haImportcustom);

    //集中器、采集器校验1
    Integer centorCollectorCheck1(HaImportcustom haImportcustom);

    //集中器、采集器校验2
    Integer centorCollectorCheck2(HaImportcustom haImportcustom);

    //集中器、采集器校验3
    Integer centorCollectorCheck3(HaImportcustom haImportcustom);

    //表类型校验1
    Integer meterTypeCheck1(HaImportcustom haImportcustom);

    //表类型校验2
    Integer meterTypeCheck2(HaImportcustom haImportcustom);

    //收费类型校验1
    Integer chargeTypeCheck1(HaImportcustom haImportcustom);

    //收费类型校验2
    Integer chargeTypeCheck2(HaImportcustom haImportcustom);

    //表序号的校验1
    Integer serialNumber1(HaImportcustom haImportcustom);

    //表序号的校验2
    Integer serialNumber2(HaImportcustom haImportcustom);

    //检测同个导入文件中存在相同表号的认为表内表号重复
    Integer serialNumber3(HaImportcustom haImportcustom);

    //导入文件中 同集中器 房间存在，序列号相同认为 与系统表序号重复
    Integer serialNumber4(HaImportcustom haImportcustom);

    //导入房间已有表
    Integer exportRoomHasForm(HaImportcustom haImportcustom);

    //同一大区 相同表号 系统查找不到对应房间认为新增房间修改表资料
    Integer thinkAddingRoom(HaImportcustom haImportcustom);

    //确定是新增还是修改1
    Integer checkAddOrUpdate1(HaImportcustom haImportcustom);

    //确定是新增还是修改2
    Integer checkAddOrUpdate2(HaImportcustom haImportcustom);

    //确定是新增还是修改3
    Integer checkAddOrUpdate3(HaImportcustom haImportcustom);

    //确定是新增还是修改4
    Integer checkAddOrUpdate4(HaImportcustom haImportcustom);

    //补全新增默认值
    HaPricestandard tpriceStandard();

    HaMetertype tmeterType(String tpriceStandard);

    Integer completeAddDefaultValues(String tmeterType, String tpriceStandard, HaImportcustom haImportcustom);

    Integer completeAddDefaultValues2(HaImportcustom haImportcustom);

    //查询总条目
    Integer queryAllHaImportCustomCount(HaImportcustom haImportcustom);

    //查询新增数
    Integer addsCount(HaImportcustom haImportcustom);

    //查询修改数
    Integer updsCount(HaImportcustom haImportcustom);

    //用户档案文档导入—新增房间资料
    Integer addRoomByExport1(HaImportcustom haImportcustom);

    Integer addRoomByExport2(HaImportcustom haImportcustom);

    //用户档案文档导入—新增用户资料
    Integer addCustomByExport1(HaImportcustom haImportcustom);

    Integer addCustomByExport2(HaImportcustom haImportcustom);

    Integer addCustomByExport3(HaImportcustom haImportcustom);

    //取消原关联导入用户编号的房间关联
    Integer cannelMeterRoomByExport(HaImportcustom haImportcustom);

    //用户档案文档导入—修改表的房间关联
    Integer updateMeterRoomByExport1(HaImportcustom haImportcustom);

    Integer updateMeterRoomByExport2(HaImportcustom haImportcustom);

    //用户档案文档导入—新增表资料
    Integer addMeterByExport(HaImportcustom haImportcustom);

    //用户档案文档导入—修改表资料
    Integer updateMeterByExport1(HaImportcustom haImportcustom);

    Integer updateMeterByExport2(HaImportcustom haImportcustom);

    //用户档案文档导入—修改用户资料
    Integer updateCustomByExport1(HaImportcustom haImportcustom);

    Integer updateCustomByExport2(String fileName,String operatorCode,String msg);
}
