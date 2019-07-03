package com.hkoo.toy.blog.controller;


import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@Slf4j
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
