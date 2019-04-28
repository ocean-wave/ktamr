package com.ktamr.management.gprsdtu;

import com.ktamr.domain.HaGprsdtu;
import com.ktamr.service.HaGprsdtuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/gprsdtu")
public class CGprsdtuController {

    @Resource
    private HaGprsdtuService haGprsdtuService;

    @RequestMapping("/gprsdtu_list")
    public String gprsdtu_list(){
        return "gprsdtu/gprsdtu_list";
    }

    @RequestMapping("/gprsdtuListJson")
    @ResponseBody
    public Object gprsdtulistjson(HaGprsdtu haGprsdtu){
        List<HaGprsdtu> haGprsdtusList = haGprsdtuService.HaGprsdtuList(haGprsdtu);
        return haGprsdtusList;
    }
}
