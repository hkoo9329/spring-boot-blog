package com.hkoo.toy.blog.domain;


import com.hkoo.toy.blog.domain.enums.Grade;
import com.hkoo.toy.blog.domain.enums.SocialType;
import com.hkoo.toy.blog.domain.enums.UserStatus;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"idx","email"})
@NoArgsConstructor
@Entity
@Table
@Data
public class User implements UserDetails {


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
    private String authority;

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
    public User(String name, String password, String email, String authority, String principal, SocialType socialType,
                LocalDateTime createdDate, LocalDateTime updatedDate){
        this.name = name;
        this.password = password;
        this.email = email;
        this.principal = principal;
        this.socialType = socialType;
//        this.status = status;
//        this.grade = grade;
        // 나중에 추가
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(this.authority));
        return authorities;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
