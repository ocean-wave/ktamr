package com.ktamr.web.controller.thirdpartyInterface;

import com.ktamr.domain.HaCmd;
import com.ktamr.common.core.domain.BaseController;
import com.ktamr.service.HaCmdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/thirdPartyInterface")
public class InterfaceCmdController extends BaseController {
    private  String pxePath = "interface";

    @Autowired
    private HaCmdService haCmdService;


    @GetMapping("/cmd")
    public String cmd(ModelMap mmap){
        return pxePath+"/interfaceCmdList";
    }

    @PostMapping("/interfaceCmdListJson")
    @ResponseBody
    public Map<String, Object> interfaceCmdListJson(HaCmd haCmd){
        startPage();
        List<HaCmd> listCmd = haCmdService.selectAllCmd(haCmd);
        return getDataTable(listCmd);
    }
}
