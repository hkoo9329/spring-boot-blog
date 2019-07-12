package com.hkoo.toy.blog.domain;


import com.hkoo.toy.blog.domain.enums.Grade;
import com.hkoo.toy.blog.domain.enums.SocialType;
import com.hkoo.toy.blog.domain.enums.UserStatus;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"idx","email"})
@NoArgsConstructor
@Entity
@Table
@Data
public class User implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String principal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public User(String name, String password, String email, String principal, SocialType socialType,
                UserStatus status, Grade grade, LocalDateTime createdDate, LocalDateTime updatedDate){
        this.name = name;
        this.password = password;
        this.email = email;
        this.principal = principal;
        this.socialType = socialType;
        this.status = status;
        this.grade = grade;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public User setInactive(){
        status = UserStatus.INACTIVE;
        return this;
    }
}
