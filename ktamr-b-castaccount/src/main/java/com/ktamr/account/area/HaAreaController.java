package com.ktamr.account.area;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ktamr.domain.HaArea;
import com.ktamr.service.HaAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class HaAreaController {


    @Resource
    private HaAreaService haAreaService;
    /**
     * 打开小区结算的页面+并进行小区名字的赋值
     * @return
     */
    @RequestMapping("/area/area_list.html")
    public String showArea_list(HaArea haArea, Model model){

        List<HaArea> haAreaList = haAreaService.selectHareaNameList(haArea);
        if(haAreaList!=null){
            model.addAttribute("areaListName",haAreaList);
            return "area/area_list.html";
        }
        return  null;
    }
     /**
     *
     * 分页查询+条件查询
     * @param haArea
     * @param request
     * @return
     */
    @RequestMapping("/area/showList")
    @ResponseBody
    public Map<String ,Object> showList(HaArea haArea,HttpServletRequest request,@RequestParam("page") int pageSize
    ,String aareaid
    ){
        String s1 = aareaid;//获取areaid  小区名字
        if(s1!=null && s1!=""){//判断小区名字如果没有赋值的话就不用查询
            String[] split = s1.split(",");
            List<Integer> idsList = new ArrayList<Integer>();
            for(int i=0;i<split.length;i++){
                idsList.add(Integer.valueOf(split[i]));
            }
            haArea.setIdsList(idsList);

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
        List<HaArea> haAreaList = haAreaService.selectHaAreaList(haArea,pageRows ,page2 );
        Integer selectHaAreaCount = haAreaService.selectHaAreaCount(haArea);
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page",page);//设置初始的页码 就是第几页
        map.put("rowNum",pageRows);//一页显示几条数据
        map.put("records",selectHaAreaCount);//总记录数
        map.put("total",(selectHaAreaCount-1)/pageRows+1);//总页数的计算
        map.put("rows",haAreaList);//存放集合

      //  String s = JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
        if(map!=null){
            return map;
        }else {
            return null;
        }

    }


    /**
     * 冻结小区
     * @param haArea
     * @return
     */
    @RequestMapping("/RowEditing")
    @ResponseBody
    public String RowRditing(HaArea haArea,String OpNumber){
        String switchAreaFreezeRead="false";

        switch(OpNumber) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                //更改值，在查询的时候搞一波
                if(haArea.getReserved().equals("true")){
                    haArea.setReserved("Y");
                }else {
                    haArea.setReserved("N");
                }
                //返回相应的记录数
                Integer selectCountareaid = haAreaService.selectCountareaid(haArea);
                if(selectCountareaid>0){
                    //更新状态一波
                    Integer updateHaArea = haAreaService.updateHaArea(haArea);
                    if(updateHaArea>0){
                        switchAreaFreezeRead="true";
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
    public String area_mng(HaArea haArea,Model model,String ids){

        int QuanJu=0;
        switch (haArea.getCmdName()){
            case "结算上传":
                String s1 = ids;//ids  小区名字
                if(s1!=null && s1!=""){//判断小区名字如果没有赋值的话就不用查询
                    String[] split = s1.split(",");
                    List<Integer> idsList = new ArrayList<Integer>();
                    for(int i=0;i<split.length;i++){
                        idsList.add(Integer.valueOf(split[i]));
                    }
                    haArea.setIdsList(idsList);
                }
                //把第一个选中的赋值一波
                haArea.setAreaId(haArea.getIdsList().get(0));
                model.addAttribute("areaids",haArea.getAreaId());
                model.addAttribute("cmdName",haArea.getCmdName());
                //点击结算上传填充小区根据传入的list集合idsList中的第一个值查询小区名字
                HaArea selectHaAreaName = haAreaService.selectHaAreaName(haArea);
                if(selectHaAreaName!=null){
                    model.addAttribute("selectHaAreaName",selectHaAreaName);
                    model.addAttribute("sumDate",new Date());
                   QuanJu=1;
                }

                break;
            case "2":
                break;
                default:
        }

        if(QuanJu>0){
            return "area/area_mng.html";
        }
        return null;
    }

    /**
     * 点击结算上传 没有选中小区编号
     * @return
     */
    @RequestMapping("/interface/interface_data_upload")
    public String interface_data_upload(){
        return "area/interface_data_upload.html";
    }

}
