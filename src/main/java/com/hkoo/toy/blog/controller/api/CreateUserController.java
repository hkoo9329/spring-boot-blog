package com.hkoo.toy.blog.controller.api;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import com.hkoo.toy.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CreateUserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/check/id")
    public boolean userIdExistsCheck(@RequestParam(value = "id") String id) {
        User user = userRepository.findByEmail(id);
        if (user == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/create/user")
    public void signUpUser(@RequestBody Map<String,String> map){
        String email = map.get("email");
        String password = map.get("password");
        String name = map.get("name");
        log.info("email : "+email);
        log.info("password : "+password);
        User user = User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
        log.info(user.getName());
        userRepository.save(user);
    }

}
