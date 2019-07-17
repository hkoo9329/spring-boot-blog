package com.hkoo.toy.blog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {
    void signUpUser(Map<String, String> userInfo);

}
