package com.ktamr.web.controller.area;

import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.poi.ExcelUtil;
import com.ktamr.common.utils.poi.ExcelUtilTwo;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaRngService;
import com.ktamr.util.PageUtil;
import com.ktamr.web.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area/area")
public class HaAreaContrller extends BaseController{
    private  String pxePath = "area";

    //定义一个全局变量
    private String Globalstate=null;

    @Autowired
    private HaAreaService haAreaService;
    @Autowired
    private HaRngService haRngService;

    @PostMapping("/areasOpManageJson")
    @ResponseBody
    public Map<String,Object> areasOpManageJson(HaArea parms){
        startPage();
        List<HaArea> listHaArea = haAreaService.selectAllAreaAndCount(parms);
        Map<String,String> map2 = new HashMap<String,String>();
        Map<Integer,String> mi = new HashMap<Integer, String>();
        mi.put(0,"sumNumber");
        mi.put(1,"readNumber");
        mi.put(2,"sumDosage");
        mi.put(3,"atnNumber");
        Map<Integer,Integer> ms = getValuesByKey(listHaArea,mi);
        map2.put("cb","总计:");
        map2.put("sumNumber",ms.get(0).toString());
        map2.put("readNumber",ms.get(1).toString());
        map2.put("sumDosage",ms.get(2).toString());
        map2.put("atnNumber",ms.get(3).toString());
        Map<String,Object> m = getDataTable(listHaArea);
        m.put("userdata",map2);
        return m;
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaArea haArea, ExcelUtilTwo excelUtilTwo)
    {
        List<HaArea> list = haAreaService.selectAllAreaAndCount(haArea);
        return excelUtilTwo.init(list, "小区表数据");
    }

    /**
     * 统计图中==》打开根据状态表查询页面
     * @param haArea
     * @return
     */
    @RequestMapping("/meter/meters_state_list")
    public String  centorList(HaArea haArea, Model model){
        Globalstate=haArea.getState();//把从页面来的状态赋给全局变量里
        List<HaRgn> haRgns = haRngService.selectBigNameB();
        if(Globalstate!=null&&haRgns!=null){
            model.addAttribute("haRgnsListName",haRgns);
            return "meter/meters_state_list.html";//返回打开的页面
        }
        return null;
    }

    /**
     * 状态表列表之==》小区列表
     * @param haArea
     * @param request
     * @param pageUtil
     * @return
     */
    @RequestMapping("/getAreaMeterState")
    @ResponseBody
    public Map<String ,Object> showList(HaArea haArea, HttpServletRequest request, PageUtil pageUtil,
                                        String aareaid
    ){
        String s1 = aareaid;//获取areaid  小区名字
        if(s1!=null && s1!=""){//判断小区名字如果没有赋值的话就不用查询
            String[] split = s1.split(",");
            List<String> idsList = new ArrayList<String>();
            for(int i=0;i<split.length;i++){
                idsList.add(split[i]);
            }
            haArea.setIdsList2(idsList);

        }
        haArea.setState(Globalstate);//将刚才设置的全局变量赋值一波
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        Integer[] integers = pageUtil.pageAndPageRow(page1, pageRows1);
        List<HaArea> haAreaList = haAreaService.AQueryHaAreabystatus(haArea, integers[0], integers[1]);
        Integer queryHaAreabystatusCount = haAreaService.AQueryHaAreabystatusCount(haArea);
        Map map = pageUtil.map(haAreaList, queryHaAreabystatusCount);
        if(map!=null){
            return map;
        }else {
            return null;
        }
    }


}
