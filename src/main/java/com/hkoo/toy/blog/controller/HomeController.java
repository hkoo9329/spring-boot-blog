package com.hkoo.toy.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcome(Model model){
        model.addAttribute("name","lee");
        return "home";
    }
}
