package com.hkoo.toy.blog.controller;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class TestApiController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public boolean getusers(@RequestParam(value = "id") String id){
        log.info(id);
        return true;
    }

    @PostMapping("/check/id")
    public boolean userIdExistsCheck(@RequestParam(value = "id") String id){
        try {
            User user = userRepository.findByEmail(id);
            if (user.equals(null)){

            }
            log.info("id : "+id);
        }catch (NullPointerException e){
            return true;
        }
        return false;
    }
}
