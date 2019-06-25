package com.hkoo.toy.blog.repository;

import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.domain.projection.UserOnlyContainName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = UserOnlyContainName.class)
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
