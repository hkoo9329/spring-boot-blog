package com.hkoo.toy.blog.domain.enums;

public enum SocialType {
    NAVER("naver"),
    GOOGLE("google"),
    KAKAO("kakao"),
    GITHUB("github");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialType(String name) {
        this.name = name;
    }

    public String getRoleType() { return ROLE_PREFIX + name.toUpperCase(); }

    public String getValue() { return name; }

    public boolean isEquals(String authority) {
        return this.name.equals(authority);
    }
}