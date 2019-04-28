package com.ktamr.management.uploads;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uploads")
public class UploadsController {

    @RequestMapping("/upload_users")
    public String upload_users(){
        return "uploads/upload_users";
    }
}
