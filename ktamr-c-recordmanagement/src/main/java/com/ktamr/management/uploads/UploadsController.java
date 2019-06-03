package com.ktamr.management.uploads;

import com.ktamr.domain.HaArea;
import com.ktamr.service.HaAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/uploads")
public class UploadsController {

    @Resource
    private HaAreaService haAreaService;

    @RequestMapping("/upload_users")
    public String upload_users(Model model){
        List<HaArea> haAreasList = haAreaService.queryAllHaAreaC();
        model.addAttribute("haAreasList",haAreasList);
        return "uploads/upload_users";
    }
}
