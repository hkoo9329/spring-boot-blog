package com.hkoo.toy.blog.service;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // 비밀번호 암호화 , 해당 Bean은 SecurityConfig에 있음
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        log.info("userName : "+name);
        User user = userRepository.findByEmail(name);
        return user;
    }

    @Override
    public void signUpUser(Map<String, String> userInfo) {
        //등급은 나중에 추가
        User user = User.builder()
                .name(userInfo.get("name"))
                .email(userInfo.get("email"))
                .password(bCryptPasswordEncoder.encode(userInfo.get("password")))//비밀번호를 암호화해서 저장
                .authority("user")
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUserEmail(String email, User user) {
        log.info(email);
        user.setEmail(email);
        userRepository.save(user);
    }

}
