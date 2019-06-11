package com.ktamr.account.area;


import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.export.ExcelUtilTwo;
import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaRgn;
import com.ktamr.common.core.domain.AjaxResult;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaRngService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class HaAreaController extends BaseController {


    @Resource
    private HaAreaService haAreaService;
    @Resource
    private HaRngService haRngService;

    /**
     * 打开小区结算的页面+并进行小区名字的赋值
     *
     * @return
     */
    @RequestMapping("/area/area_list.html")
    public String showArea_list(Model model) {

        // List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        List<HaRgn> haRgns = haRngService.selectBigNameB();
        if (haRgns != null) {
            model.addAttribute("haRgnsListName", haRgns);
            return "area/area_list.html";
        }
        return null;
    }

    /**
     * 分页查询+条件查询
     *
     * @param haArea
     * @return
     */
    @RequestMapping("/area/showList")
    @ResponseBody
    public Map<String, Object> showList(HaArea haArea, String aareaid
    ) {
        startPage();
        String s1 = aareaid;//获取areaid  小区名字
        if (s1 != null && s1 != "") {//判断小区名字如果没有赋值的话就不用查询
            String[] split = s1.split(",");
            List<String> idsList = new ArrayList<String>();
            for (int i = 0; i < split.length; i++) {
                idsList.add(split[i]);
            }
            haArea.setIdsList2(idsList);
        }
        List<HaArea> haAreaList = haAreaService.selectHaAreaList(haArea);
        return getDataTable(haAreaList);

    }

    /**
     * 导出小区表信息
     *
     * @param haArea
     * @param excelUtilTwo
     * @return
     */
    @PostMapping("/area/export")
    @ResponseBody
    public AjaxResult export(HaArea haArea, ExcelUtilTwo excelUtilTwo) {
        //这里保证查询的是全部的数据
        List<HaArea> list = haAreaService.selectHaAreaList(haArea);
        if (list != null) {
            return excelUtilTwo.init(list, "小区表数据");
        }
        return null;
    }

    /**
     * 冻结小区
     *
     * @param haArea
     * @return
     */
    @RequestMapping("/RowEditing")
    @ResponseBody
    public String RowRditing(HaArea haArea, String OpNumber) {
        String switchAreaFreezeRead = "false";

        switch (OpNumber) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                //更改值，在查询的时候搞一波
                if (haArea.getReserved().equals("true")) {
                    haArea.setReserved("Y");
                } else {
                    haArea.setReserved("N");
                }
                //返回相应的记录数
                Integer selectCountareaid = haAreaService.selectCountareaid(haArea);
                if (selectCountareaid > 0) {
                    //更新状态一波
                    Integer updateHaArea = haAreaService.updateHaArea(haArea);
                    if (updateHaArea > 0) {
                        switchAreaFreezeRead = "true";
                    }
                }
                break;
            default:


        }
        return switchAreaFreezeRead;
    }

    /**
     * 点击结算上传 有选中小区编号
     *
     * @param haArea
     * @return
     */
    @RequestMapping("/area_mng")
    public String area_mng(HaArea haArea, Model model, String ids) {

        int QuanJu = 0;
        switch (haArea.getCmdName()) {
            case "结算上传":
                String s1 = ids;//ids  小区名字
                if (s1 != null && s1 != "") {//判断小区名字如果没有赋值的话就不用查询
                    String[] split = s1.split(",");
                    List<Integer> idsList = new ArrayList<Integer>();
                    for (int i = 0; i < split.length; i++) {
                        idsList.add(Integer.valueOf(split[i]));
                    }
                    haArea.setIdsList(idsList);
                }
                //把第一个选中的赋值一波
                haArea.setAreaId(haArea.getIdsList().get(0));
                model.addAttribute("areaids", haArea.getAreaId());
                model.addAttribute("cmdName", haArea.getCmdName());
                //点击结算上传填充小区根据传入的list集合idsList中的第一个值查询小区名字
                HaArea selectHaAreaName = haAreaService.selectHaAreaName(haArea);
                if (selectHaAreaName != null) {
                    model.addAttribute("selectHaAreaName", selectHaAreaName);
                    model.addAttribute("sumDate", new Date());
                    QuanJu = 1;
                }

                break;
            case "2":
                break;
            default:
        }

        if (QuanJu > 0) {
            return "area/area_mng.html";
        }
        return null;
    }

    /**
     * 点击结算上传 没有选中小区编号
     *
     * @return
     */
    @RequestMapping("/interface/interface_data_upload")
    public String interface_data_upload() {
        return "area/interface_data_upload.html";
    }

}
