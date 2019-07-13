package com.hkoo.toy.blog;

import com.hkoo.toy.blog.domain.Board;
import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.domain.enums.BoardType;
import com.hkoo.toy.blog.repository.BoardRepository;
import com.hkoo.toy.blog.repository.UserRepository;
import com.hkoo.toy.blog.resolver.UserArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class BlogApplication implements WebMvcConfigurer {

    @Autowired
    private UserArgumentResolver userArgumentResolver;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userArgumentResolver);
    }

}
