package com.hkoo.toy.blog.controller;

import com.hkoo.toy.blog.annotation.Socialuser;
import com.hkoo.toy.blog.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginSuccess")
    public String loginComplete(@Socialuser User user){
        return "redirect:/board/list";
    }
}
