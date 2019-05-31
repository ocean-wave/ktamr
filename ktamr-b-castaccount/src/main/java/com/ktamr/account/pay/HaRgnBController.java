package com.ktamr.account.pay;

import com.ktamr.domain.HaArea;
import com.ktamr.domain.HaRgn;
import com.ktamr.service.HaAreaService;
import com.ktamr.service.HaRngService;
import com.ktamr.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/area")
public class HaRgnBController {
    private static  final String pxePath = "/area";

    @Autowired
    private HaRngService haRngService;

    @Autowired
    private HaAreaService haAreaService;

    @RequestMapping("/")
    public String index(){

        List<HaRgn> list = new ArrayList<HaRgn>();
        list = haRngService.selectAllRngAndCountB();

        return "index";
    }
    @RequestMapping("/areasOpManage")
    public String areasOpManage(){

        return pxePath+"/areasOpManage";
    }

    @RequestMapping("/areasOpManageJson")
    @ResponseBody
    public Map<String,Object> areasOpManageJson(){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("cb","总计:");
        map2.put("haAreaCount","89");
        map2.put("haCentorCount","28642");
        map2.put("haCollectorCount","7");
        map2.put("haMeterCount","1829");
        List<HaRgn> listHaRgn = haRngService.selectAllRngAndCountB();
        map.put("records",14);
        map.put("page",1);
        map.put("total",1);
        map.put("rows", listHaRgn);
        map.put("userdata",map2);
        return map;
    }

    /**
     * 这次返回Json数组
     * @return
     */
    @RequestMapping("/showBigNameB")
    @ResponseBody
    public Object showBigName(){

        List<Menu> menus=new ArrayList<Menu>();
        //追加1级菜单
        Menu menu1=new Menu();
        //声明1级菜单
        menu1.setId("-1");
        menu1.setpId("0");
        menu1.setLevelType("allRgn");
        menu1.setName("全部区域");
        menu1.setIconSkin("icon00");
        menu1.setIsParent(false);
        //把1级菜单添加进去
        menus.add(menu1);

        //查询大区名字
        List<HaRgn> haRgnList = haRngService.selectBigNameB();

        //循环遍历并添加2级菜单
        for(int i = 0 ; i < haRgnList.size() ; i++) {
          Menu menu2 =new Menu();
          menu2.setId(haRgnList.get(i).getId());
          menu2.setpId("0");
          menu2.setLevelType("rgn");
          menu2.setName(haRgnList.get(i).getName()+"("+haRgnList.get(i).getHaArea().getCountAreaNo()+")");
          menu2.setIconSkin("pIcon01");
          menu2.setIsParent(true);

          //获取小区名字
            List<HaArea> haAreas = haAreaService.selectSmallName(haRgnList.get(i).getId());
            if(haAreas.size()!=0){

            //定义3级菜单存放在2级菜单中的setChildren
            List<Menu> menu3=new ArrayList<Menu>();
            for (int j=0;j<haAreas.size();j++){

                Menu menu33 =new Menu();
                menu33.setId(String.valueOf(haAreas.get(j).getAreaId()));
                menu33.setpId(String.valueOf(haRgnList.get(i).getId()));
                menu33.setLevelType("area");
                menu33.setName(haAreas.get(j).getRegisteredNo()+"-"+haAreas.get(j).getHaName());
                menu33.setIconSkin("pIcon02");
                menu33.setIsParent(false);
                menu3.add(menu33);
                menu2.setChildren(menu3);
            }
            }else {
                List<Menu> menu3=new ArrayList<Menu>();
                menu2.setChildren(menu3);
            }
            menus.add(menu2);//添加2级菜单
        }

        return menus;
    }
}
