package com.hkoo.toy.blog.service;

import com.hkoo.toy.blog.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {
    void signUpUser(Map<String, String> userInfo);
    void updateUserEmail(String email, User user);

}
