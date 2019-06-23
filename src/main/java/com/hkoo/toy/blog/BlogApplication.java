package com.hkoo.toy.blog;

import com.hkoo.toy.blog.domain.Board;
import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.domain.enums.BoardType;
import com.hkoo.toy.blog.repository.BoardRepository;
import com.hkoo.toy.blog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }


}
