package com.ktamr.management.gprsdtu;

import com.ktamr.common.core.domain.BaseController;
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
public class CGprsdtuController extends BaseController {

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
    public Object gprsdtulistjson(HaGprsdtu haGprsdtu){
        startPage();
        List<HaGprsdtu> haGprsdtusList = haGprsdtuService.HaGprsdtuList(haGprsdtu);
        Map<String, Object> map = getDataTable(haGprsdtusList);
        int centors = 0;
        for (int i = 0; i < haGprsdtusList.size(); i++) {
            if(haGprsdtusList.get(i).getCentors()!=null){
                centors += haGprsdtusList.get(i).getCentors();
            }
        }
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("cb", "总计:");
        map2.put("centors", centors);
        map.put("userdata", map2);
        return map;
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
            return "true";
        }
        return "false";
    }

    @RequestMapping("/addingCellValidation")
    @ResponseBody
    public String addingCellValidation(HaGprsdtu haGprsdtu){
        Integer addingCellValidation = haGprsdtuService.addingCellValidation(haGprsdtu);
        if(addingCellValidation==1){
            return "True";
        }
        return "false";
    }
}
