package com.ktamr.service;

import com.ktamr.domain.HatMetersreplace;

import java.util.List;
import java.util.Map;

public interface HatMetersReplaceService {
    List<HatMetersreplace> HatMetersReplaceList(HatMetersreplace hatMetersreplace);

    //将excel文档中的数据导入到零时表中
    Integer addHatMetersReplace(List<Map<String, Object>> params);

    //导入用户编号校验1
    Integer exportCustomNoCheck1(HatMetersreplace hatMetersreplace);

    //导入用户编号校验2
    Integer exportCustomNoCheck2(HatMetersreplace hatMetersreplace);

    //导入档案内表号校验1
    Integer exportArchivesMeterNumCheck1(HatMetersreplace hatMetersreplace);

    //导入档案内表号校验2
    Integer exportArchivesMeterNumCheck2(HatMetersreplace hatMetersreplace);

    //导入档案内表号校验3
    Integer exportArchivesMeterNumCheck3(HatMetersreplace hatMetersreplace);

    //导入档案内表号校验4
    Integer exportArchivesMeterNumCheck4(HatMetersreplace hatMetersreplace);

    //导入档案内表号校验5
    Integer exportArchivesMeterNumCheck5(HatMetersreplace hatMetersreplace);

    //匹配用户编号
    Integer matchCustomNo(HatMetersreplace hatMetersreplace);

    //匹配旧表表号
    Integer matchOldMeterNo(HatMetersreplace hatMetersreplace);

    //补齐默认数值
    Integer makeUpDefaultNum(HatMetersreplace hatMetersreplace);

    //插入一条批量换表命令
    Integer addBatchChangeMeter(String fileName,String operatorCode,String msg);

    //插入旧表最终抄表记录
    Integer addOldMeterLastMeterRead(HatMetersreplace hatMetersreplace);

    // 插入旧表最终日冻结数据(昨日)
    Integer addOldMeterLastDayFrozen1(HatMetersreplace hatMetersreplace);

    Integer addOldMeterLastDayFrozen2(HatMetersreplace hatMetersreplace);

    Integer addOldMeterLastDayFrozen3(HatMetersreplace hatMetersreplace);

    //插入旧表最终月冻结数据(上月)
    Integer addOldMeterLastMonthFrozen1(HatMetersreplace hatMetersreplace);

    Integer addOldMeterLastMonthFrozen2(HatMetersreplace hatMetersreplace);

    Integer addOldMeterLastMonthFrozen3(HatMetersreplace hatMetersreplace);

    //换表
    Integer changeMeter(HatMetersreplace hatMetersreplace);

    //插入换表记录
    Integer addChangeMeterNote(HatMetersreplace hatMetersreplace);

    //完成换表
    Integer finishChangeMeter(HatMetersreplace hatMetersreplace);

    //清理零时表
    Integer deleteHatMetersReplace(HatMetersreplace hatMetersreplace);

    //总条目数
    Integer allrows(HatMetersreplace hatMetersreplace);

    //待换数
    Integer replaces(HatMetersreplace hatMetersreplace);
}
