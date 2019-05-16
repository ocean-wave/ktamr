package com.ktamr.web.controller.handworkmeterreading;

import com.ktamr.service.HaMeterService;
import com.ktamr.web.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/handworkmeterreading")
public class HandDeviceTransController extends BaseController {
    private  String pxePath = "area";

    @Autowired
    private HaMeterService haMeterService;


    @GetMapping("/deviceTrans")
    public String deviceTrans(ModelMap mmap){
        return pxePath+"/handDeviceTrans";
    }
}
