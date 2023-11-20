package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
class PostController {
    @GetMapping("/posts")
    public String postindex(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("First Post", "This is the content of the first post."));
        posts.add(new Post("Second Post", "This is the content of the second post."));
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String postId(Model model){
        Post post = new Post("Single Post", "This is the content of the single post.");
        model.addAttribute("post", post);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String createForm(){
        return "this shows the create post form";
    }
    @PostMapping("/posts/create")
    public String createPost(){
        return "this shows the created post?";
    }
}
