package com.ktamr.web.datacopy.controller.systemmaintenance;

import com.ktamr.domain.*;
import com.ktamr.service.*;
import com.ktamr.web.datacopy.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/systemmaintenance")
public class CmdListController extends BaseController {
    private  String pxePath = "/datamng";

    @Autowired
    private HaCmdService haCmdService;

    @Autowired
    private HaMeterAddrService haMeterAddrService;

    @GetMapping("/cmdList")
    public String cmdList(ModelMap mmap){
        return pxePath+"/cmdList";
    }

    @PostMapping("/cmdListJson")
    @ResponseBody
    public Map<String, Object> cmdListJson(HaCmd haCmd){
        startPage();
        List<HaCmd> listCmd = haCmdService.selectCmdLeftJoinTow(haCmd);
        return getDataTable(listCmd);
    }

    @GetMapping("/cmdResultListShow")
    public String cmdResultListShow(@RequestParam( value = "cmdid") Integer cmdid,
                                    ModelMap mmap){
        HaCmd haCmd = haCmdService.selectCmdById(cmdid);
        mmap.put("sTitle","[命令:"+haCmd.getCmd()+":"+haCmd.getParms()+"]");
        mmap.put("cmdid",cmdid);
        mmap.put("cmdName",haCmd.getCmd());
        return pxePath+"/cmdResultListShow";
    }

    @PostMapping("/cmdResultListShow1Json")
    @ResponseBody
    public Map<String, Object> cmdResultListShow1Json(HaCmd haCmd){
        startPage();
        List<HaCmd> listCmd = haCmdService.selectCmdLeftJoinTow(haCmd);
        return getDataTable(listCmd);
    }

    @PostMapping("/cmdResultListShow2Json")
    @ResponseBody
    public Map<String, Object> cmdResultListShow2Json(@RequestParam("cmdName") String cmdName,@RequestParam("cmdId") Integer cmdId){
        startPage();
        if(cmdName.equals("读表地址")){
            List<HaMeterAddr> listMeterAddr = haMeterAddrService.selectMeterAddrLeftJoinTow(cmdId);
            return getDataTable(listMeterAddr);
        }else{

        }
        return null;
    }
}
