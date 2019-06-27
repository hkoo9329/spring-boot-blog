package com.hkoo.toy.blog.domain.projection;

import com.hkoo.toy.blog.domain.Board;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "getOnlyTitle", types = {Board.class})
public interface BoardOnlyContainTitle {
    String getTitle();
}

