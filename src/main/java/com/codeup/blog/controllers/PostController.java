package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postResponse() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id) {
        return "User " + id + "'s individual post";

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
