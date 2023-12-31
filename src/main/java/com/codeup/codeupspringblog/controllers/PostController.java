package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    @GetMapping("/posts/create")
    public String createForm(Model model){
        model.addAttribute("createPost", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        post.setUsers(user);
        postDao.save(post);
        emailService.prepareAndSend(post , "Post Created", "Hello, your post has been created!");

        postDao.save(post);
        return "redirect:/posts/index";
    }
    @GetMapping("/posts/delete/{id}")
    public String deletePostById(@PathVariable(name= "id") long id) {
        postDao.deleteById(id);
        return "redirect:/posts/index";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable(name = "id") long id, Model model){
        Post post = postDao.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPostById(@PathVariable(name = "id") long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = postDao.findById(id).orElse(null);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/index";
    }
}
