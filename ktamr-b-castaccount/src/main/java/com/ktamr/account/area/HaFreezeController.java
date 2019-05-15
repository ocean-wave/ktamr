package com.ktamr.account.area;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaFreeze;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaFreezeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class HaFreezeController {

    @Resource
    private HaFreezeService haFreezeService;

    @Resource
    private HaAreaService haAreaService;


    /**
     * 点击小区结算的功能按钮
     * @param haFreeze
     * @return
     */
    @RequestMapping("/bill_op")
    @ResponseBody
    public String bill_op(HaFreeze haFreeze, HaArea haArea, HttpSession session){

        //判断是否点击费用结算按钮的事件
        if(haFreeze.getOpType().equals("费用结算")){
            Integer insertHaFreeze1 = haFreezeService.insertHaFreeze11(haFreeze);
            Integer insertHaFreeze2 = haFreezeService.insertHaFreeze12(haFreeze);
            Integer binsertHaFreeze2 = haFreezeService.BinsertHaFreeze2(haFreeze);
            Integer binsertHaFreeze3 = haFreezeService.BinsertHaFreeze3(haFreeze);
            Integer binsertHaFreeze41 = haFreezeService.BinsertHaFreeze41(haFreeze);
            Integer binsertHaFreeze42 = haFreezeService.BinsertHaFreeze42(haFreeze);
            Integer binsertHaFreeze43 = haFreezeService.BinsertHaFreeze43(haFreeze);
            Integer binsertHaFreeze51 = haFreezeService.BinsertHaFreeze51(haFreeze);
            Integer binsertHaFreeze52 = haFreezeService.BinsertHaFreeze52(haFreeze);
            if((insertHaFreeze1+insertHaFreeze2+binsertHaFreeze2+binsertHaFreeze3+binsertHaFreeze41+binsertHaFreeze42
            +binsertHaFreeze43+binsertHaFreeze51+binsertHaFreeze52
            )>0){
                return "<font color='green'>费用结算成功</font>";
            }
        }else if (haFreeze.getOpType().equals("完成结算")){
            Object attribute = session.getAttribute("operatorCode");
            Integer integer1 = haAreaService.updateWanChengJieSuanOne(haArea);
            haArea.setOpertorCode(String.valueOf(attribute));
            Integer integer2 = haAreaService.updateWanChenJieSuanTwo(haArea);
            Integer integer3 = haAreaService.updateWanChenJieSuanThree(haArea);
            Integer integer4 = haAreaService.updateWanChenJieSuanFour(haArea);
            Integer integer5 = haAreaService.updateWanChenJieSuanFive(haArea);
            Integer integer6 = haAreaService.updateWanChenJieSuanSix(haArea);
            Integer integer7 = haAreaService.updateWanChenJieSuanSeven(haArea);
            if((integer1+integer2+integer3+integer4+integer5+integer6+integer7)>0){
                return "<font color='green'>完成结算成功</font>";
            }


        }
        return "<font color='red'>操作失败</font>";
    }



}
