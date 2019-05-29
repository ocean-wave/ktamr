package com.ktamr.web.controller;

import com.ktamr.common.config.Global;
import com.ktamr.ShiroUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexContrller {

    @RequestMapping("/index")
    public String index(ModelMap mmap, HttpSession session){
        mmap.put("webVersion", Global.getWebVersion());
        mmap.put("version", Global.getVersion());
        session.setAttribute("haOperator", ShiroUtils.getHaOperator());
        session.setAttribute("rgnAndAreaId", ShiroUtils.getRgnAndAreaId());
        return "index";
    }
}
