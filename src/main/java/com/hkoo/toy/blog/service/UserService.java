package com.hkoo.toy.blog.service;

import com.hkoo.toy.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String userSignUpChecker(){

        return null;
    }
}
