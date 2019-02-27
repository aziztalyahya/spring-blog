package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String postResponse(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title", "body", 1));
        posts.add( new Post("title2", "body2", 2));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = new Post("title", "body", 1);
        model.addAttribute("post", post);
        return "posts/show";

    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getPost() {
        return "form for creating new posts";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam(name = "post") String post) {
        return post;
    }

}
