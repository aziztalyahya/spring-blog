package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


    @PostMapping("/hello")
    @ResponseBody
    public String getPassword(@RequestParam(name = "password") String password){
        return "123" + password + "asdasd";
    }

    @GetMapping("/testJSON.json")
    @ResponseBody
    public List getList(){
        List<String> names = new ArrayList<>();
        names.add("Aziz");
        names.add("Shawn");
        return names;
    }
}
