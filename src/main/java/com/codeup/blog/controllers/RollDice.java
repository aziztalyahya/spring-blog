package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDice {

    @GetMapping("/roll")
    public String rollPage(){
        return "roll";
    }

    @GetMapping("/roll/{choice}")
    public String rollMade(@PathVariable int choice, Model model){
        int randomNum = (int) Math.ceil(Math.random() * 6);
        model.addAttribute("choice", choice);
        model.addAttribute("randomNum", randomNum);
        Boolean answerIsCorrect = false;
        if (randomNum == choice) {
             answerIsCorrect = true;
        }
        model.addAttribute("answerIsCorrect", answerIsCorrect);

        return "rollMade";
    }
}
