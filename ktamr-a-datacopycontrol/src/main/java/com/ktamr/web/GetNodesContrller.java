package com.ktamr.web;

import com.ktamr.common.core.domain.BaseController;
import com.ktamr.common.utils.sql.SqlCondition;
import com.ktamr.service.NodesService;
import com.ktamr.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/nodes")
public class GetNodesContrller extends BaseController {

    @Autowired
    private NodesService nodesService;

    @RequestMapping("/getNodes")
    @ResponseBody
    public String getAreaNodes(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        String jsonStr = "[{ id:'-1', pId:0, LevelType:'allRgn', name:'全部大区', iconSkin:'icon00', open:true},{ id:'-2', pId:0, LevelType:'allArea', name:'全部小区', iconSkin:'icon00', open:true},{ id:'-3', pId:0, LevelType:'allMeter', name:'全部房间表', iconSkin:'icon00', open:true}";
        List<Map<String,Object>> listHaRgn = nodesService.selectAllRgnNodes(map);
        for  (Map<String,Object> haRgn : listHaRgn){
            jsonStr = jsonStr + ",{ id:'" +haRgn.get("id")+ "', pId:0, LevelType:'rgn', name:' "+haRgn.get("id")+"-"  + haRgn.get("name") + "(" + haRgn.get("haareacount") + ")', iconSkin:'pIcon01', isParent:true, children:[";
            map.put("id",haRgn.get("id").toString());
            List<Map<String,Object>> listMap = nodesService.selectAllAreaNodes(map);
            for(Map<String,Object> m : listMap ){
                jsonStr = jsonStr +  "{ id:'" + m.get("areaid").toString() + "', pId:'"+ haRgn.get("id") +"', LevelType:'area', name:'" + m.get("ar") +"-"+m.get("aname") + "(" + m.get("bnamecount") +")', iconSkin:'pIcon02', isParent:true, children:[";
                List<Map<String,Object>> listMap2 = nodesService.selectAllBuildingNodes(Integer.parseInt(m.get("areaid").toString()));
                int i = 1;
                for (Map<String,Object> m2:listMap2 ){
                    int j=1;
                    jsonStr = jsonStr + "{ id:'" + m2.get("buildingid") + "', pId:'"+ m.get("areaid") +"', LevelType:'building', name:'" + m2.get("name") + "(" + m2.get("roomid") +")', iconSkin:'icon03', isParent:false}";
                    if (j != listMap2.size()){
                        jsonStr = jsonStr + ",";
                    }
                }
                jsonStr = jsonStr + "]}";
                if (i != listMap.size()){
                    jsonStr = jsonStr + ",";
                }
            }
            jsonStr = jsonStr+"]}";
        }
        jsonStr = jsonStr + "]";
        return jsonStr;
    }

    @RequestMapping("/getAreaNodes")
    @ResponseBody
    public String getAreaNodes(@RequestParam(value = "parameterType",required = false) String parameterType){
        Map<String,Object> map = new HashMap<String, Object>();
        if(parameterType!=null){
            map.put("parameterType",parameterType);
        }
        map.put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        String jsonStr = "[{ id:'-1', pId:0, LevelType:'allCentor', name:'全部区域', iconSkin:'icon00',isParent:false}";
        List<Map<String,Object>> listHaRgn = nodesService.selectAllRgnNodes(map);
        for  (Map<String,Object> haRgn : listHaRgn){
            jsonStr = jsonStr + ",{ id:'" +haRgn.get("id")+ "', pId:0, LevelType:'rgn', name:' "+haRgn.get("id")+"-" + haRgn.get("name") + "(" + haRgn.get("haareacount") + ")', iconSkin:'pIcon01', isParent:true, children:[";
            map.put("id",haRgn.get("id").toString());
            map.put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
            List<Map<String,Object>> listMap = nodesService.selectAllAreaNodes(map);
            for(Map<String,Object> m : listMap ){
                jsonStr = jsonStr +  "{ id:'" + m.get("areaid").toString() + "', pId:'"+ haRgn.get("id") +"', LevelType:'area', name:'" + m.get("ar") +"-"+m.get("aname") + "(" + m.get("bnamecount") +")', iconSkin:'pIcon02'}";
                int i = 1;
                if (i != listMap.size()){
                    jsonStr = jsonStr + ",";
                }
            }
            jsonStr = jsonStr+"]}";
        }
        jsonStr = jsonStr + "]";
        return jsonStr;
    }

    @RequestMapping("/getEquipmentCentorzNodes")
    @ResponseBody
    public String getEquipmentCentorzNodes(@RequestParam( value = "areaType" ,required = false) String areaType,
                                           @RequestParam( value = "id",required = false) String id){
        String jsonStr = "[{ id:'-1', pId:0, LevelType:'allCentor', name:'全部集中器', iconSkin:'icon00'}";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("areaType",areaType);
        map.put("id",id);
        map.put("getRightCondition", SqlCondition.getRightCondition("a.areano","area","and"));
        List<Map<String,Object>> listCentor = nodesService.selectAllCentorzNodes(map);
        for  (Map<String,Object> haCentor : listCentor){
            jsonStr = jsonStr + ",{ id:'"+haCentor.get("id")+"', pId:'0', LevelType:'centorz', name:'"+haCentor.get("columns")+""+haCentor.get("addr")+"("+haCentor.get("collectorcount")+")', description:'"+haCentor.get("description")+"', iconSkin:'pIcon04', isParent:true, children:[";
            List<Map<String,Object>> listCollector = nodesService.selectAllCollectorNodes(Integer.parseInt(haCentor.get("id").toString()));
            int i = 1;
            for(Map<String,Object> m : listCollector ){
                jsonStr = jsonStr +  "{ id:'"+m.get("collectorid")+"', pId:'"+haCentor.get("id")+"', LevelType:'collector', name:'"+m.get("nconf")+""+m.get("addr")+"("+m.get("metercount")+")', iconSkin:'pIcon05', isParent:false}";
                if (i != listCollector.size()){
                    jsonStr = jsonStr + ",";
                }
                i++;
            }
            jsonStr = jsonStr+"]}";
        }
        jsonStr = jsonStr + "]";
        return jsonStr;
    }

    @RequestMapping("/getEquipmentCentorcNodes")
    @ResponseBody
    public String getEquipmentCentorcNodes(@RequestParam( value = "areaType",required = false) String areaType,
                                           @RequestParam( value = "id",required = false) String id){
        String jsonStr = "[{ id:'-1', pId:0, LevelType:'allCentor', name:'全部集采器', iconSkin:'icon00', open:true}";
        Map<String,Object> map = new HashMap<>();
        map.put("getRightCondition", SqlCondition.getRightCondition("ce.centorno","area","and"));
        map.put("areaType",areaType);
        map.put("id",id);
        List<Map<String,Object>> listCentor = nodesService.selectAllCentorcNodes(map);
        for  (Map<String,Object> haCentor : listCentor){
            jsonStr = jsonStr + ",{ id:'"+haCentor.get("id")+"', pId:'0', LevelType:'centorc', name:'"+haCentor.get("centorid")+""+haCentor.get("addr")+"("+haCentor.get("meteridcount")+")', description:'"+haCentor.get("description")+"', iconSkin:'pIcon04'}";
        }
        jsonStr = jsonStr + "]";
        return jsonStr;
    }
}
