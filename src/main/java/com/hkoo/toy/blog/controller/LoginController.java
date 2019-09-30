package com.hkoo.toy.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/loginSuccess")
    public String loginComplete(){
        return "redirect:/board/list";
    }

    @RequestMapping("/loginFail")
    public String loginFail(Model model){
        log.info("login fail");
        model.addAttribute("message","fail");
        return "login";
    }
}
