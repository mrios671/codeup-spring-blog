package com.codeup.codeupspringblog;

import com.codeup.codeupspringblog.repositories.PostRepository;
import com.mysql.cj.PreparedQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
class PostController {

    private final PostRepository postDao;

    PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts/index")
    public String postindex(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String postId(Model model, @PathVariable(name = "id") long id){
        Post post = postDao.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePostById(@PathVariable(name= "id") long id){
        postDao.deleteById(id);
        return "redirect:/posts/index";
    }

    @GetMapping("/posts/create")
    public String createForm(){
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){

        Post newPost = new Post(title, body);

        postDao.save(newPost);

        return "redirect:/posts/index";
    }
}
