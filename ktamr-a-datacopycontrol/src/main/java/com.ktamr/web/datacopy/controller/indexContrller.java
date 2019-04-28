package com.ktamr.web.datacopy.controller;

import com.ktamr.common.config.Global;
import com.ktamr.common.utils.ServletUtils;
import com.ktamr.service.HaOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexContrller {

    @Autowired
    private HaOperatorService haOperatorService;

    @RequestMapping("/index")
    public String index(ModelMap mmap, HttpSession session){
        mmap.put("webVersion", Global.getVersion());
        mmap.put("operatorName", ServletUtils.getSession().getAttribute("operatorName"));
        return "/index";
    }
}
