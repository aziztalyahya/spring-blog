package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String postResponse(Model model) {
        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postIdGet(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/showOne";

    }

    @PostMapping("/posts/{id}/edit")
    public String postIdPost(@PathVariable long id,@RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description){
        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(description);
        postDao.save(post);

        return "redirect:/posts/" + id;
    }


    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @GetMapping("/posts/create")
    public String getPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        // save the ad...
        save(post);
        // redirect to to the index with all the ads
        return "redirect:/posts";
    }

    public void save(Post post){
        postDao.save(post);
    }

//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name = "title") String title,
//                             @RequestParam(name = "description") String description) {
//        Post post = new Post(title, description);
//        postDao.save(post);
//        return "redirect:/posts";
//    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "id") long id) {
        Post post = postDao.findOne(id);
        postDao.delete(post);

        return "redirect:/posts";

    }

}
