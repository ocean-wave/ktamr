package com.ktamr.service.impl;

import com.ktamr.domain.HaFreeze;
import com.ktamr.mapper.HaFreezeMapper;
import com.ktamr.service.HaFreezeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HaFreezeServiceImpl implements HaFreezeService {

    @Resource
    private HaFreezeMapper haFreezeMapper;

    /**
     * 点击费用结算所做的步骤1
     * @param haFreeze
     * @return
     */
    @Override
    public Integer insertHaFreeze11(HaFreeze haFreeze) {
        Integer insertHaFreeze1 = haFreezeMapper.BinsertHaFreeze11(haFreeze);
        if(insertHaFreeze1!=null){
            return insertHaFreeze1;
        }
        return null;
    }

    /**
     * 点击费用结算所做的步骤2
     * @param haFreeze
     * @return
     */
    @Override
    public Integer insertHaFreeze12(HaFreeze haFreeze) {
        Integer insertHaFreeze2 = haFreezeMapper.BinsertHaFreeze12(haFreeze);
        if(insertHaFreeze2!=null){
            return insertHaFreeze2;
        }
        return null;
    }

    /**
     * 2、阶梯费用计算 点击费用结算所做的步骤3
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze2(HaFreeze haFreeze) {
        Integer binsertHaFreeze3 = haFreezeMapper.BinsertHaFreeze2(haFreeze);
        if(binsertHaFreeze3!=null){
            return binsertHaFreeze3;
        }
        return null;
    }

    /**
     * 3、生成新缴费单（对相应的用户）点击费用结算所做的步骤3
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze3(HaFreeze haFreeze) {
        Integer binsertHaFreeze3 = haFreezeMapper.BinsertHaFreeze3(haFreeze);
        if(binsertHaFreeze3!=null){
            return binsertHaFreeze3;
        }
        return null;
    }

    /**
     * 4、取消未完成结算的缴费单 点击费用结算所做的步骤4
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze41(HaFreeze haFreeze) {
        Integer binsertHaFreeze41 = haFreezeMapper.BinsertHaFreeze41(haFreeze);
        if(binsertHaFreeze41!=null){
            return binsertHaFreeze41;
        }
        return null;
    }

    /**
     * 修改之前未完成结算缴费单状态 点击费用结算所做的步骤4.2
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze42(HaFreeze haFreeze) {
        Integer binsertHaFreeze42 = haFreezeMapper.BinsertHaFreeze42(haFreeze);
        if(binsertHaFreeze42!=null){
            return binsertHaFreeze42;
        }
        return null;
    }

    /**
     * 修改ha_custom 上次的 billid 点击费用结算所做的步骤4.3
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze43(HaFreeze haFreeze) {
        Integer binsertHaFreeze43 = haFreezeMapper.BinsertHaFreeze43(haFreeze);
        if(binsertHaFreeze43!=null){
            return binsertHaFreeze43;
        }
        return null;
    }

    /**
     * 在ha_monthBTime表中加入结算查询时间区间的起始时间 点击费用结算所做的步骤5.1
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze51(HaFreeze haFreeze) {
        Integer binsertHaFreeze51 = haFreezeMapper.BinsertHaFreeze51(haFreeze);
        if(binsertHaFreeze51!=null){
            return binsertHaFreeze51;
        }
        return null;
    }

    /**
     * 点击费用结算所做的步骤5.2 即最后步骤
     * @param haFreeze
     * @return
     */
    @Override
    public Integer BinsertHaFreeze52(HaFreeze haFreeze) {
        Integer binsertHaFreeze52 = haFreezeMapper.BinsertHaFreeze52(haFreeze);
        if(binsertHaFreeze52!=null){
            return binsertHaFreeze52;
        }
        return null;
    }

    /**
     * 点击打印缴费单时进行查询2
     * @param haFreeze
     * @return
     */
    @Override
    public HaFreeze BselectPritJiaoFeiDan2(HaFreeze haFreeze) {
        HaFreeze bselectPritJiaoFeiDan2 = haFreezeMapper.BselectPritJiaoFeiDan2(haFreeze);
        if(bselectPritJiaoFeiDan2!=null){
            return  bselectPritJiaoFeiDan2;
        }
        return null;
    }
}
