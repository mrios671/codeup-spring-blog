package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MathController {
    @GetMapping("/add/{firstnumber}/and/{secondnumber}")
    @ResponseBody
    public String add(@PathVariable int firstnumber, @PathVariable int secondnumber){
        return firstnumber + " plus " + secondnumber + " is equal to " + (firstnumber + secondnumber);
    }
    @GetMapping("/subtract/{firstnumber}/from/{secondnumber}")
    @ResponseBody
    public String subtract(@PathVariable int firstnumber, @PathVariable int secondnumber){
        return firstnumber + " minus " + secondnumber + " is equal to " + (secondnumber - firstnumber);
    }
    @GetMapping("/multiply/{firstnumber}/and/{secondnumber}")
    @ResponseBody
    public String multiply(@PathVariable int firstnumber, @PathVariable int secondnumber){
        return firstnumber + " times " + secondnumber + " is equal to " + (firstnumber * secondnumber);
    }
    @GetMapping("/divide/{firstnumber}/by/{secondnumber}")
    @ResponseBody
    public String divide(@PathVariable int firstnumber, @PathVariable int secondnumber){
        return firstnumber + " divided by " + secondnumber + " is equal to " + (firstnumber / secondnumber);
    }
}
