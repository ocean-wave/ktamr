package com.ktamr.account.pay;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.common.utils.DateUtils;
import com.ktamr.domain.HaBillrecords;
import com.ktamr.domain.HaMonthbtime;
import com.ktamr.service.HaBillrecordsService;
import com.ktamr.service.HaMonthbtimeService;
import com.ktamr.util.PageUtil;
import com.ktamr.util.Tool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HaBillrecordsController {

    @Resource
    private HaBillrecordsService haBillrecordsService;

    @Resource
    private HaMonthbtimeService haMonthbtimeService;


    @RequestMapping("/com/ktamr/account/pay/cust_recharge_list.html")
    public String showCust_recharge_list(){
        return "com/ktamr/account/pay/cust_recharge_list.html";
    }

    /**
     * 用于测试
     * @param haBillrecords
     * @return
     */
    @RequestMapping("/showBillRecordsList/showBillRecordsList")
    @ResponseBody
    public  String  showBillRecordsList(HaBillrecords haBillrecords, HttpServletRequest request,  @RequestParam("startDate") Object startDate, @RequestParam("endDate")Object endDate

    ){

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        if(startDate!=null&&startDate!="" &&endDate!=null&&endDate!=""){


            try {
                Date start= sdf.parse(String.valueOf(startDate));
                Date end = sdf.parse(String.valueOf(endDate));
                haBillrecords.setKaiShi(start);
                haBillrecords.setJieShu(end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Integer page,pageRows;

        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if(page1==null&&pageRows1==null){//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        }else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2=page;//重新定义变量接收
        --page2;
        List<HaBillrecords> haAreaList =haBillrecordsService.queryHaBillrecordsList(haBillrecords,pageRows ,page2 );
        Integer selectHaAreaCount = haBillrecordsService.ChaXunHaBillrecordsCount(haBillrecords);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",selectHaAreaCount);//总记录数
        map.put("total",(selectHaAreaCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haAreaList);//存放集合

        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);

        if(s!=null){
            return s;
        }
        return null;
    }

    /**
     * 查询用户账单列表
     * @param haBillrecords
     * @param request
     * @param pageUtil
     * @return ajax
     */
    @RequestMapping("/selectYongHuZhangDan")
    @ResponseBody
     public String queryHaCustomList(HaBillrecords haBillrecords , HttpServletRequest request, PageUtil pageUtil
    , String startDate, String endDate,String page

    ) {
        if(startDate!=null&&startDate!="" &&endDate!=null&&endDate!=""){
            Date start = Tool.RiQiZhuanHua(startDate);
            Date end = Tool.RiQiZhuanHua(endDate);
            haBillrecords.setKaiShi(start);
            haBillrecords.setJieShu(end);
        }



        //接收一波
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        //通过方法返回一波
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaBillrecords> haBillrecordsList = haBillrecordsService.selectYongHuZhangDan(haBillrecords, integers[0], integers[1]);

        Integer selectYongHuZhangDanCount = haBillrecordsService.selectYongHuZhangDanCount(haBillrecords);
        Map map = pageUtil.map(haBillrecordsList, selectYongHuZhangDanCount);
        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if (s != null) {
            return s;
        }
        return null;
    }

    /**
     * 打开导入余额页面
     * @param haBillrecords
     * @return
     */
    @RequestMapping("/cust_balance_import")
    public String cust_balance_import(HaBillrecords haBillrecords){
        return "com/ktamr/account/pay/cust_balance_import.html";
    }


    /**
     * 填充结算周期下拉框
     * @param haMonthbtime
     * @return
     */
    @RequestMapping("/load_monthBTime")
    @ResponseBody
    public List<String> load_monthBTime(HaMonthbtime haMonthbtime){
        List<HaMonthbtime> haMonthbtimeList = haMonthbtimeService.BselectTime(haMonthbtime);//获取开始结束时间
        if(haMonthbtimeList!=null){
            List<String> list = new ArrayList<String>();//创建集合对象；

            for (int i=0;i<haMonthbtimeList.size();i++){
                //对其进行赋值

                String std= DateUtils.parseDateToStr("yyyy-MM-dd HH24:mm:ss",haMonthbtimeList.get(i).getStartTime())+'~'+DateUtils.parseDateToStr("yyyy-MM-dd HH24:mm:ss",haMonthbtimeList.get(i).getEndTime())+';';
                list.add(std);
            }
            return list;
        }

        return  null;
    }
}
