package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    @GetMapping("/roll")
    public String rollPage(Model model){
        return "roll";
    }

    @GetMapping("/roll/choice")
    public String rollMade(@RequestParam int choice, Model model){
        int randomNum = (int) Math.ceil(Math.random() * 20);
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
