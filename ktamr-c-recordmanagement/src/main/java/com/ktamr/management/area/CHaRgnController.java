package com.ktamr.management.area;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaBuilding;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.*;
import com.ktamr.util.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/area")
public class CHaRgnController {
    private static  final String pxePath = "/area";

    @Autowired
    private HaRngService haRngService;

    @Autowired
    private AllBigAreaService allBigAreaService;

    @Autowired
    private AllSmallAreaService allSmallAreaService;

    @Autowired
    private AllRoomService allRoomService;

    @Autowired
    private AllBuildingService allBuildingService;

    @RequestMapping("/JumpRgnAdd")
    public String jumprgnadd(){
        return "/area/rgn_add";
    }

    @RequestMapping("/JumpRgnUpdate")
    public String jumprgnupdate(HaRgn haRgn,Model model,String rgnId){
        haRgn.setId(rgnId);
        HaRgn rgn = haRngService.updateByIdRng(haRgn);
        model.addAttribute("rgn",rgn);
        model.addAttribute("rgnId",rgnId);
        return "/area/rgn_update";
    }

    @RequestMapping("/JumpRgnDelete")
    public String jumprgndelete(HaRgn haRgn, Model model, String rgnId){
        haRgn.setId(rgnId);
        HaRgn rgn = haRngService.updateByIdRng(haRgn);
        model.addAttribute("rgn",rgn);
        model.addAttribute("rgnId",rgnId);
        return "/area/rgn_del";
    }

    @RequestMapping("/areasOpManageJson")
    @ResponseBody
    public Object areasOpManageJson(HaRgn haRgn, HttpServletRequest request){
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
        List<HaRgn> haRgns = haRngService.selectAllRngAndCount(haRgn, pageRows, page2);
        Integer haRgnCount = haRngService.HaRgnCount(haRgn);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",haRgnCount);//总记录数
        map.put("total",(haRgnCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haRgns);//存放集合

        int areaCount = 0;
        int centorCount = 0;
        int collectorCount = 0;
        int meterCount = 0;
        for(int i = 0;i<haRgns.size();i++){
            areaCount+=haRgns.get(i).getHaAreaCount();
            centorCount+=haRgns.get(i).getHaCentorCount();
            collectorCount+=haRgns.get(i).getHaCollectorCount();
            meterCount+=haRgns.get(i).getHaMeterCount();
        }
        Map<String ,Object> map2=new HashMap<String, Object>();
        map2.put("cb","总计:");
        map2.put("haAreaCount",areaCount);
        map2.put("haCentorCount",centorCount);
        map2.put("haCollectorCount",collectorCount);
        map2.put("haMeterCount",meterCount);
        map.put("userdata",map2);
        return map;
    }

    @RequestMapping("/AddRgn")
    @ResponseBody
    public Object addRgn(HaRgn haRgn){
        String id = null;
        Integer count0 = haRngService.count0();
        Integer countA = haRngService.countA();
        Integer countla = haRngService.countla();
        Integer countNumber = haRngService.countNumber();
        Integer countUpperCase = haRngService.countUpperCase();
        String elseId = haRngService.elseId();
        if(count0==0){
            id = "0";
            haRgn.setId(id);
            haRgn.setCreateTime(new Date());
            haRgn.setModifyTime(new Date());
            Integer addHaRgn = haRngService.addHaRgn(haRgn);
            if(addHaRgn==1){
                return "true";
            }
            return "false";
        }else if(countNumber==0 && countA ==0){
            id = "A";
            haRgn.setId(id);
            haRgn.setCreateTime(new Date());
            haRgn.setModifyTime(new Date());
            Integer addHaRgn = haRngService.addHaRgn(haRgn);
            if(addHaRgn==1){
                return "true";
            }
            return "false";
        }else if(countUpperCase==26 && countla==0){
            id="a";
            haRgn.setId(id);
            haRgn.setCreateTime(new Date());
            haRgn.setModifyTime(new Date());
            Integer addHaRgn = haRngService.addHaRgn(haRgn);
            if(addHaRgn==1){
                return "true";
            }
            return "false";
        }else{
            if(elseId!=null){
                id = elseId;
                haRgn.setId(id);
                haRgn.setCreateTime(new Date());
                haRgn.setModifyTime(new Date());
                Integer addHaRgn = haRngService.addHaRgn(haRgn);
                if(addHaRgn==1){
                    return "true";
                }
                return "false";
            }else {
                return "超过新增数量限制！";
            }
        }
    }

    @RequestMapping("/UpdateRgn")
    @ResponseBody
    public Object updateRgn(HaRgn haRgn){
        haRgn.setModifyTime(new Date());
        Integer updateHaRgn = haRngService.updateHaRgn(haRgn);
        if(updateHaRgn==1){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeleteRgn")
    @ResponseBody
    public Object deleteRgn(HaRgn haRgn){
        Integer deleteHaRgn = haRngService.deleteHaRgn(haRgn);
        if(deleteHaRgn==1){
            return "删除成功";
        }
        return "false";
    }
}
