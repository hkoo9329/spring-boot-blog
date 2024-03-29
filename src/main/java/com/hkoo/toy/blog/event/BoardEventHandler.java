package com.hkoo.toy.blog.event;

import com.hkoo.toy.blog.domain.Board;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler
public class BoardEventHandler {

    @HandleBeforeCreate
    public void beforeCreateBoard(Board board){
        board.setCreatedDateNow();
    }

    @HandleBeforeSave
    public void beforeSaveBaord(Board board){
        board.setUpdatedDateNow();
    }
}
