package com.hkoo.toy.blog.domain.projection;

import com.hkoo.toy.blog.domain.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "getOnlyName", types = {User.class})
public interface UserOnlyContainName {
    String getName();
}