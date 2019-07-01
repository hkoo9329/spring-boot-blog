package com.hkoo.toy.blog.controller;


import com.hkoo.toy.blog.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    @GetMapping("")
    public String welcome(){
        return "home";
    }
    @GetMapping("/error")
    public String errorPage(){
        return "error";
    }

    @GetMapping("/test")
    public Authentication currentUserLogin(Authentication authentication){
        return authentication;
    }
}
