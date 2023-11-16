package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {
    @GetMapping("/index")
    @ResponseBody
    public String greeting(){
        return "This is the landing page!";
    }
}
