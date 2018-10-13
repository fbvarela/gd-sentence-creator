package com.gd.demo.controller;

import com.gd.demo.domain.Word;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @GetMapping("/index")
    public String formGet() {
        return "index.html";
    }

    @PostMapping("/home23")
    public String formPost(Word word, Model model) {
        model.addAttribute("word", word);
        return "word";
    }
}

//TODO: Retrieve de form data