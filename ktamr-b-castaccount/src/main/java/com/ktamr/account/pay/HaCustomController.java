package com.ktamr.account.pay;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.domain.HaBillrecords;
import com.ktamr.domain.HaCustom;
import com.ktamr.service.HaBillrecordsService;
import com.ktamr.service.HaCustomService;
import com.ktamr.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class HaCustomController {

    @Resource
    private HaCustomService haCustomService;
    @Resource
    private HaBillrecordsService haBillrecordsService;


    /**
     * 打开用户账户页面
     * @return
     */
    @RequestMapping("/com/ktamr/account/pay/cust_balance_list.html")
    public String showCust_balance_list(){
        return "com/ktamr/account/pay/cust_balance_list.html";
    }

    /**
     * 打开用户账户列表
     * @param haCustom
     * @param request
     * @return
     */
    @RequestMapping("/queryHaCustomList")
    @ResponseBody
    public String queryHaCustomList(HaCustom haCustom ,HttpServletRequest request,PageUtil pageUtil){
        //接收一波
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        //通过方法返回一波
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaCustom> haCustomList = haCustomService.queryHaCustomList(haCustom, integers[0], integers[1]);
        Integer haCustomListCount = haCustomService.queryHaCustomListCount(haCustom);
        Map map = pageUtil.map(haCustomList, haCustomListCount);
        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if(s!=null){
            return s;
        }
        return null;
    }


    /**
     * 此方法用于查询用户账户中的预存费用,并打开费用查询页面
     * @param haCustom
     * @return
     */
    @RequestMapping("/opencust_bill_operation")
    public String testYuCunFeiYong(HaCustom haCustom, Model model){
        HaCustom yuCunFeiYong = haCustomService.selectYuCunFeiYong(haCustom);
        if(yuCunFeiYong!=null){
            model.addAttribute("HaCustomYuCunHuaFei",yuCunFeiYong);//存放数据
            return "/com/ktamr/account/pay/cust_bill_operation.html";
        }
        return null;
    }

    /**
     * 预存费用的实现
     * @return 根据返回值 返回Layer输出的东东
     */
    @RequestMapping("/cust_bill_operation_do")
    @ResponseBody
    public String cust_bill_operation_do(HaCustom haCustom, HaBillrecords haBillrecords){



        if(haBillrecords.getOptType().equals("恢复收费")){
            String s = haBillrecordsService.selectShiFou(haBillrecords);
            if(s.equals("true")){
            return "超过可恢复收费";
            }
        }



        //先更新一波
        Integer updateYuCunFeiYong = haCustomService.updateYuCunFeiYong(haCustom);

        //再添加一波
        Integer insertHaBillrecords = haBillrecordsService.insertHaBillrecords(haBillrecords);

        //如果两数返回值是1+1=2的情况下就返回true即返回成功
        if(updateYuCunFeiYong+insertHaBillrecords==2){
            return "true";
        }


        return  "操作失败";
    }

    /**
     * 打开用户账户列表 并存值
     * @param haCustom
     * @param model
     * @return
     */
    @RequestMapping("/cust_bill_list2")
    public String cust_bill_list2(HaCustom haCustom,Model model){

        HaCustom yuCunFeiYong = haCustomService.selectYuCunFeiYong(haCustom);
        if(yuCunFeiYong!=null){
            model.addAttribute("HaCustomYuCunHuaFei",yuCunFeiYong);//存放数据
            return "/com/ktamr/account/pay/cust_bill_list2.html";
        }
        return  null;
    }


}
