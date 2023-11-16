package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postindex(){
        return "posts index page";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(){
        return "view and individual post. ";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "view the form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "view the form for creating a post";
    }
}
