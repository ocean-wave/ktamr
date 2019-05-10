package com.ktamr.management.gprsdtu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.domain.HaGprsdtu;
import com.ktamr.service.HaGprsdtuService;
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
@RequestMapping("/gprsdtu")
public class CGprsdtuController {

    @Resource
    private HaGprsdtuService haGprsdtuService;

    @RequestMapping("/gprsdtu_list")
    public String gprsdtu_list(){
        return "gprsdtu/gprsdtu_list";
    }

    @RequestMapping("/JumpAddGprsdtu")
    public String jumpAddGprsdtu(){return "/gprsdtu/dtu_add";}

    @RequestMapping("/JumpUpdateGprsdtu")
    public String jumpUpdateGprsdtu(String uId, HaGprsdtu haGprsdtu, Model model){
        haGprsdtu.setuId(uId);
        HaGprsdtu gprsdtu = haGprsdtuService.updateByIdHaGprsdtu(haGprsdtu);
        model.addAttribute("gprsdtu",gprsdtu);
        model.addAttribute("uId",uId);
        return "/gprsdtu/dtu_update";
    }

    @RequestMapping("/JumpDeleteGprsdtu")
    public String jumpDeleteGprsdtu(String uids, HaGprsdtu haGprsdtu, Model model){
        haGprsdtu.setuId(uids);
        HaGprsdtu gprsdtu = haGprsdtuService.updateByIdHaGprsdtu(haGprsdtu);
        model.addAttribute("gprsdtu",gprsdtu);
        model.addAttribute("uId",uids);
        return "/gprsdtu/dtu_del";
    }

    @RequestMapping("/gprsdtuListJson")
    @ResponseBody
    public Object gprsdtulistjson(HaGprsdtu haGprsdtu, HttpServletRequest request){
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
        List<HaGprsdtu> haGprsdtusList = haGprsdtuService.HaGprsdtuList(haGprsdtu,pageRows,page2);
        Integer haGprsdtuCount = haGprsdtuService.HaGprsdtuCount(haGprsdtu);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",haGprsdtuCount);//总记录数
        map.put("total",(haGprsdtuCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haGprsdtusList);//存放集合
        String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if(s!=null){
            return s;
        }
        return null;
    }

    @RequestMapping("/AddGprsdtu")
    @ResponseBody
    public Object addGprsdtu(HaGprsdtu haGprsdtu){
        Integer gprsdtu = haGprsdtuService.addHaGprsdtu(haGprsdtu);
        if(gprsdtu==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/updateHaGprsdtu")
    @ResponseBody
    public Object updateHaGprsdtu(HaGprsdtu haGprsdtu){
        Integer gprsdtu = haGprsdtuService.updateHaGprsdtu(haGprsdtu);
        if(gprsdtu==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/deleteHaGprsdtu")
    @ResponseBody
    public Object deleteHaGprsdtu(HaGprsdtu haGprsdtu){
        Integer gprsdtu = haGprsdtuService.deleteHaGprsdtu(haGprsdtu);
        if(gprsdtu==1){
            return "删除成功";
        }
        return "false";
    }
}
