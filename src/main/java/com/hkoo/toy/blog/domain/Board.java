package com.hkoo.toy.blog.domain;


import com.hkoo.toy.blog.domain.enums.BoardType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String subTitle;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private Long test;

    @Builder
    public Board(String title, String subTitle, String content, BoardType boardType,
                 LocalDateTime createdDate, LocalDateTime updatedDate,Long test, User user){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.boardType = boardType;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
//        this.user = user;
        this.test = test;
    }
    public void setCreatedDateNow() {
        this.createdDate = LocalDateTime.now();
    }

    public void setUpdatedDateNow() {
        this.updatedDate = LocalDateTime.now();
    }

}
