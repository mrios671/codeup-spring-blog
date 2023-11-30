package com.codeup.codeupspringblog.controllers;

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
    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}
