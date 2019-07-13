package com.hkoo.toy.blog.batch.jobs;

import com.hkoo.toy.blog.domain.User;
import org.springframework.batch.item.ItemProcessor;

public class InactiveItemProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) throws Exception {
        return user.setInactive();
    }
}