package com.hkoo.toy.blog.repository;

import com.hkoo.toy.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
