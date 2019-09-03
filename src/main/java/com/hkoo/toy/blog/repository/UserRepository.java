package com.hkoo.toy.blog.repository;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.domain.enums.UserStatus;
import com.hkoo.toy.blog.domain.projection.UserOnlyContainName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(excerptProjection = UserOnlyContainName.class)
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
    User findByPrincipal(String principal);
}
