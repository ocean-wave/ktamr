package com.ktamr.management.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login(String appPage) {
        return "login";
    }


}
