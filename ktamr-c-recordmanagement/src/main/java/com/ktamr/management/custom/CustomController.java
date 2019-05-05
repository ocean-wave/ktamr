package com.ktamr.management.custom;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaBuilding;
import com.ktamr.domain.HaCustom;
import com.ktamr.domain.HaRoom;
import com.ktamr.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/custom")
public class CustomController {

    @Resource
    private HaCustomService haCustomService;

    @Resource
    private HaAreaService haAreaService;

    @Resource
    private HaBuildingService haBuildingService;

    @Resource
    private HaRoomService haRoomService;

    @RequestMapping("/cust_list")
    public String cust_list() {
        return "custom/cust_list";
    }

    @RequestMapping("/JumpCustAdd")
    public String jumpcustadd(Integer areaId,Integer buildingId,Model model) {
        List<HaArea> haArea = haAreaService.queryAllHaAreaC();
        List<HaBuilding> haBuilding = haBuildingService.queryHaBuildingC(areaId);
        List<HaRoom> haRoom = haRoomService.queryRoomC(buildingId);
        model.addAttribute("haArea",haArea);
        model.addAttribute("haBuilding",haBuilding);
        model.addAttribute("haRoom",haRoom);
        return "custom/cust_add";
    }

    @RequestMapping("/JumpCustUpdate")
    public String jumpcustupdate() {
        return "custom/cust_update";
    }

    @RequestMapping("/custListJson")
    @ResponseBody
    public Object custlistjson(HaCustom haCustom, HttpServletRequest request) {
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
        List<HaCustom> haCustomsList = haCustomService.HaCustomList(haCustom,pageRows ,page2);
        Integer selectHaCustomCount = haCustomService.selectHaCustomCount(haCustom);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",selectHaCustomCount);//总记录数
        map.put("total",(selectHaCustomCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haCustomsList);//存放集合
        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if(s!=null){
            return s;
        }
        return null;
    }

    @RequestMapping(value = "/QueryHaAreaJson",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String queryHaAreaJson(){
        List<HaArea> haAreas = haAreaService.queryAllHaAreaC();
        if(haAreas!=null){
            return JSON.toJSONString(haAreas);
        }
        return null;
    }

    @RequestMapping(value = "/QueryHaBuildingJson",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public Object queryHaBuildingJson(Integer areaId){
        return JSON.toJSONString(haBuildingService.queryHaBuildingC(areaId));
    }

    @RequestMapping(value = "/QueryRoomJson",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public Object queryRoomJson(Integer buildingId){
        return JSON.toJSONString(haRoomService.queryRoomC(buildingId));
    }

    @RequestMapping("/cust_del")
    public String cust_del(HaCustom haCustom,Model model,Integer custids){
        haCustom.setCustId(custids);
        HaCustom custom = haCustomService.updateByIdHaCustom(haCustom);
        model.addAttribute("custom",custom);
        model.addAttribute("custId",custids);
        return "custom/cust_del";
    }

    @RequestMapping("/DeleteHaCustom")
    @ResponseBody
    public Object deleteHaCustom(HaCustom haCustom){
        Integer custom = haCustomService.deleteHaCustom(haCustom);
        if(custom==1){
            return "删除成功";
        }
        return "false";
    }

}
