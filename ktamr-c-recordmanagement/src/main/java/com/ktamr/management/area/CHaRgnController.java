package com.ktamr.management.area;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.common.utils.poi.ExcelUtilTwo;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaBuilding;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.*;
import com.ktamr.util.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/area")
public class CHaRgnController {
    private static final String pxePath = "/area";

    @Autowired
    private HaRngService haRngService;

    @Autowired
    private HaAreaService haAreaService;

    @Autowired
    private HaBuildingService haBuildingService;

    @RequestMapping("/JumpRgnAdd")
    public String jumprgnadd() {
        return "area/rgn_add";
    }

    @RequestMapping("/JumpRgnUpdate")
    public String jumprgnupdate(HaRgn haRgn, Model model, String rgnId) {
        haRgn.setId(rgnId);
        HaRgn rgn = haRngService.updateByIdRngC(haRgn);
        model.addAttribute("rgn", rgn);
        model.addAttribute("rgnId", rgnId);
        return "area/rgn_update";
    }

    @RequestMapping("/JumpRgnDelete")
    public String jumprgndelete(HaRgn haRgn, Model model, String rgnId) {
        haRgn.setId(rgnId);
        HaRgn rgn = haRngService.updateByIdRngC(haRgn);
        model.addAttribute("rgn", rgn);
        model.addAttribute("rgnId", rgnId);
        return "area/rgn_del";
    }

    @RequestMapping("/areasOpManageJsonC")
    @ResponseBody
    public Object areasOpManageJson(HaRgn haRgn, HttpServletRequest request) {
        Integer page, pageRows;
        String page1 = request.getParameter("page");//获取需要多少行
        String pageRows1 = request.getParameter("rows");//获取查询的起点位置
        if (page1 == null && pageRows1 == null) {//为了防止异常给它初始化一波
            page = 100;
            pageRows = 100;
        } else {//如果有那就获取一波
            page = Integer.parseInt(page1); // 取得当前页数
            pageRows = Integer.parseInt(pageRows1); // 取得每页显示行数
        }
        int page2 = page;//重新定义变量接收
        --page2;
        List<HaRgn> haRgns = haRngService.selectAllRngAndCountC(haRgn, pageRows, page2);
        Integer haRgnCount = haRngService.HaRgnCountC(haRgn);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);//设置初始的页码 就是第几页
        map.put("rowNum", pageRows);//一页显示几条数据
        map.put("records", haRgnCount);//总记录数
        map.put("total", (haRgnCount - 1) / pageRows + 1);//总页数的计算
        map.put("rows", haRgns);//存放集合

        int areaCount = 0;
        int centorCount = 0;
        int collectorCount = 0;
        int meterCount = 0;
        int badMeterCount = 0;
        for (int i = 0; i < haRgns.size(); i++) {
            areaCount += haRgns.get(i).getHaAreaCount();
            centorCount += haRgns.get(i).getHaCentorCount();
            collectorCount += haRgns.get(i).getHaCollectorCount();
            meterCount += haRgns.get(i).getHaMeterCount();
            if(haRgns.get(i).getBadMeterCount()!=null){
                badMeterCount += haRgns.get(i).getBadMeterCount();
            }
        }
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("cb", "总计:");
        map2.put("haAreaCount", areaCount);
        map2.put("haCentorCount", centorCount);
        map2.put("haCollectorCount", collectorCount);
        map2.put("haMeterCount", meterCount);
        map2.put("badMeterCount", badMeterCount);
        map.put("userdata", map2);
        return map;
    }

    @RequestMapping("/ShowBigNameC")
    @ResponseBody
    public Object showBigName() {
        List<Menus> menus = new ArrayList<Menus>();

        Menus allRgn = new Menus();
        allRgn.setId("-1");
        allRgn.setpId("0");
        allRgn.setLevelType("allRgn");
        allRgn.setName("全部区域");
        allRgn.setIconSkin("icon00");
        allRgn.setOpen(true);

        Menus allArea = new Menus();
        allArea.setId("-2");
        allArea.setpId("0");
        allArea.setLevelType("allArea");
        allArea.setName("全部小区");
        allArea.setIconSkin("icon00");
        allRgn.setOpen(true);

        Menus allRoom = new Menus();
        allRoom.setId("-3");
        allRoom.setpId("0");
        allRoom.setLevelType("allMeter");
        allRoom.setName("全部房间表");
        allRoom.setIconSkin("icon00");
        allRgn.setOpen(true);

        //添加所有大区菜单
        menus.add(allRgn);
        menus.add(allArea);
        menus.add(allRoom);

        //所有大区
        List<HaRgn> haRgnList = haRngService.queryAllBigAreaC();

        //循环遍历并添加成每个大区
        for (int i = 0; i < haRgnList.size(); i++) {
            Menus rgn = new Menus();
            rgn.setId(haRgnList.get(i).getId());
            rgn.setpId("0");
            rgn.setLevelType("rgn");
            rgn.setName(haRgnList.get(i).getName() + "(" + haRgnList.get(i).getHaArea().getHaAreaCount() + ")");
            rgn.setIconSkin("pIcon01");
            rgn.setParent(true);

            //所有小区
            List<HaArea> haAreaList = haAreaService.queryAllSmallArea2(haRgnList.get(i).getId());
            //循环遍历将指定小区放在大区下
            if (haAreaList.size() != 0) {
                List<Menus> area = new ArrayList<Menus>();
                for (int a = 0; a < haAreaList.size(); a++) {
                    Menus areas = new Menus();
                    areas.setId(String.valueOf(haAreaList.get(a).getAreaId()));
                    areas.setpId(haRgnList.get(i).getId());
                    areas.setLevelType("area");
                    areas.setName(haAreaList.get(a).getAreaId() + "-" + haAreaList.get(a).getName());
                    areas.setIconSkin("pIcon02");
                    areas.setParent(true);
                    area.add(areas);
                    rgn.setChildren(area);

                    //所有房间
                    List<HaBuilding> haBuildingList = haBuildingService.queryHaBuildingConditionC(haAreaList.get(a).getAreaId());
                    //循环遍历将指定房间放在小区下
                    if (haBuildingList.size() != 0) {
                        List<Menus> room = new ArrayList<Menus>();
                        for (int r = 0; r < haBuildingList.size(); r++) {
                            Menus rooms = new Menus();
                            rooms.setId(String.valueOf(haBuildingList.get(r).getBuildingId()));
                            rooms.setpId(String.valueOf(haAreaList.get(a).getAreaId()));
                            rooms.setLevelType("building");
                            rooms.setName(haBuildingList.get(r).getName() + "(" + haBuildingList.get(r).getBuildingCount() + ")");
                            rooms.setIconSkin("icon03");
                            rooms.setParent(false);
                            room.add(rooms);
                            areas.setChildren(room);
                        }
                    } else {
                        List<Menus> room = new ArrayList<Menus>();
                        areas.setChildren(room);
                    }
                }
                menus.add(rgn);//添加菜单
            }
        }
//        String s = JSON.toJSONString(menus);
//        System.out.println(s);
        return menus;
    }

    @RequestMapping("/ShowBigName23")
    @ResponseBody
    public Object showBigName23() {
        List<Menus> menus = new ArrayList<Menus>();

        Menus allRgn = new Menus();
        allRgn.setId("-1");
        allRgn.setpId("0");
        allRgn.setLevelType("allRgn");
        allRgn.setName("全部区域");
        allRgn.setIconSkin("icon00");
        allRgn.setOpen(true);

        //添加所有大区菜单
        menus.add(allRgn);

        //所有大区
        List<HaRgn> haRgnList = haRngService.queryAllBigAreaC();

        //循环遍历并添加成每个大区
        for (int i = 0; i < haRgnList.size(); i++) {
            Menus rgn = new Menus();
            rgn.setId(haRgnList.get(i).getId());
            rgn.setpId("0");
            rgn.setLevelType("rgn");
            rgn.setName(haRgnList.get(i).getName() + "(" + haRgnList.get(i).getHaArea().getHaAreaCount() + ")");
            rgn.setIconSkin("pIcon01");
            rgn.setParent(true);

            //所有小区
            List<HaArea> haAreaList = haAreaService.queryAllSmallArea2(haRgnList.get(i).getId());
            //循环遍历将指定小区放在大区下
            if (haAreaList.size() != 0) {
                List<Menus> area = new ArrayList<Menus>();
                for (int a = 0; a < haAreaList.size(); a++) {
                    Menus areas = new Menus();
                    areas.setId(String.valueOf(haAreaList.get(a).getAreaId()));
                    areas.setpId(haRgnList.get(i).getId());
                    areas.setLevelType("area");
                    areas.setName(haAreaList.get(a).getAreaId() + "-" + haAreaList.get(a).getName());
                    areas.setIconSkin("pIcon02");
                    areas.setParent(true);
                    area.add(areas);
                    rgn.setChildren(area);
                }
                menus.add(rgn);//添加菜单
            }
        }
        return menus;
    }

    @RequestMapping("/AddRgn")
    @ResponseBody
    public Object addRgn(HaRgn haRgn) {
        String id = null;
        Integer count0 = haRngService.count0();
        Integer countA = haRngService.countA();
        Integer countla = haRngService.countla();
        Integer countNumber = haRngService.countNumber();
        Integer countUpperCase = haRngService.countUpperCase();
        String elseId = haRngService.elseId();
        if (count0 == 0) {
            id = "0";
            haRgn.setId(id);
            haRgn.setCreateTime(new Date());
            haRgn.setModifyTime(new Date());
            Integer addHaRgn = haRngService.addHaRgnC(haRgn);
            if (addHaRgn == 1) {
                return "true";
            }
            return "false";
        } else if (countNumber == 0 && countA == 0) {
            id = "A";
            haRgn.setId(id);
            haRgn.setCreateTime(new Date());
            haRgn.setModifyTime(new Date());
            Integer addHaRgn = haRngService.addHaRgnC(haRgn);
            if (addHaRgn == 1) {
                return "true";
            }
            return "false";
        } else if (countUpperCase == 26 && countla == 0) {
            id = "a";
            haRgn.setId(id);
            haRgn.setCreateTime(new Date());
            haRgn.setModifyTime(new Date());
            Integer addHaRgn = haRngService.addHaRgnC(haRgn);
            if (addHaRgn == 1) {
                return "true";
            }
            return "false";
        } else {
            if (elseId != null) {
                id = elseId;
                haRgn.setId(id);
                haRgn.setCreateTime(new Date());
                haRgn.setModifyTime(new Date());
                Integer addHaRgn = haRngService.addHaRgnC(haRgn);
                if (addHaRgn == 1) {
                    return "true";
                }
                return "false";
            } else {
                return "超过新增数量限制！";
            }
        }
    }

    @RequestMapping("/UpdateRgn")
    @ResponseBody
    public Object updateRgn(HaRgn haRgn) {
        haRgn.setModifyTime(new Date());
        Integer updateHaRgn = haRngService.updateHaRgnC(haRgn);
        if (updateHaRgn == 1) {
            return "true";
        }
        return "false";
    }

    @RequestMapping("/DeleteRgn")
    @ResponseBody
    public Object deleteRgn(HaRgn haRgn) {
        Integer deleteHaRgn = haRngService.deleteHaRgnC(haRgn);
        if (deleteHaRgn == 1) {
            return "删除成功";
        }
        return "false";
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HaRgn haRgn, ExcelUtilTwo excelUtilTwo)
    {
        List<HaRgn> list = haRngService.selectAllRngAndCountC(haRgn,1,99);
        return excelUtilTwo.init(list, "大区表数据");
    }
}
