package com.codeup.codeupspringblog;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
    public String createForm(){
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post newPost = new Post(title, body);
        User user = userDao.getReferenceById(1L);
        newPost.setUsers(user);

        postDao.save(newPost);
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
