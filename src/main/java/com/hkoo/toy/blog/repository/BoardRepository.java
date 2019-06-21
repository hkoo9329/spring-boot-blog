package com.hkoo.toy.blog.repository;

import com.hkoo.toy.blog.domain.Board;
import com.hkoo.toy.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository <Board,Long> {
    Board findByUser(User user);
}
