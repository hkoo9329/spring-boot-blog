package com.hkoo.toy.blog.repository;

import com.hkoo.toy.blog.domain.Board;
import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.domain.projection.BoardOnlyContainTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(excerptProjection = BoardOnlyContainTitle.class)
public interface BoardRepository extends JpaRepository <Board,Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends Board> S save(S entity);

    @RestResource
    List<Board> findByTitle(@Param("title") String title);

    Board findByUser(User user);
}
