# spring boot를 이용한 블로그



## 사용 기술

1. Spring Boot (version은 2.1.5)

2. Spring Security

3. OAuth2  ( Google, Github, Kakao )  - naver는 추가 예정   ~~언제가 될지....~~

4. thymeleaf

5. mysql

6. JQuery
   

![](http://www.pickis.co.kr/content/contents/upload/2017-04/58edd86a0f389.JPG)

가 되지 않도록.....




### 진행상황

##### 2019.06.12 : OAuth2 Google, kakko 추가 api에서 redirect 변경 해야함 NAVER는 트러블 개선 필요
##### 2019.06.22 : google, kakao, github OAuth2, 구현 but naver OAuth2는 추후에 추가 예정
##### ~~2019.06.24 : CRUD를 위한 api 서버 생성 -> [https://github.com/leejuhyeok/spring-boot-blog-api]~~(지금은 따로 api 서버를 만들지 않을 예정이라서 변경)
##### 2019.06.25 : data-rest으로 변경 (같은 포트를 사용함으로 CORS를 사용 X , 생성했던 api 서버 repo는 유지)

##### 2019.07.01 :  batch 추가, 로그인 후 뒤로가기 버튼으로 다시 로그인 페이지로 가는 문제 수정

##### 2019.07.04 : SingUp 구현, Ajax에 대해 이해함. 부트스트랩으로 깔끔하게 만들라고 했으나 그건 추후에.... 지금은 일단 기능 구현 부터

##### 2019.7.17 : 로그인 기능, 회원가입 기능 추가 ~~(안쓰다가 한번에 씀, 여러가지를 더 했으나 지금 기억나는 것은 이것뿐 하핫)~~










### 참고 사이트
- kakao api 사이트 : https://developers.kakao.com/
- naver api 사이트 : https://developers.naver.com/main/
- google api 사이트 : https://console.developers.google.com/apis
- 무료 이미지 사이트 : https://pixabay.com/ko/



### 해야할 일

- [x] MySQL DB에 insert 구성하기
- [x] Pageable 기능에 대해 변경
- [x] mysql utf-8 설정을 안해서 고생한 내용 추가
- [x] 로그인 후 back button 누르면 다시 로그인 페이지로 가는 버그 수정
- [x] SingUp 구현
- [x] 현재 사용자의 이름을 가져오는 로직 만들기
- [x] 회원가입 기능 추가
- [x] DB를 기반으로 하는 로그인 기능 추가
- [x] 비밀번호를 암호화 해서 저장하는 기능 추가

### 정리
 - [필요 코드들](./study/Codes.md)
 - [mysql 연동시 오류 해결 방법](./study/MySQLError.md)
 - [새창띄우기_자바스크립트](https://m.blog.naver.com/PostView.nhn?blogId=racoon_z&logNo=220606460942&proxyReferer=https%3A%2F%2Fwww.google.com%2F)
 - [뒤로가기 버튼 제어](https://stackoverflow.com/questions/18147302/how-to-handle-back-button-using-spring-security)
 - [Spring Security OAuth2.0 파헤치기! -1](https://coding-start.tistory.com/158)
 - [스프링 Ajax 파라미터 받기](http://javakorean.com/%EC%8A%A4%ED%94%84%EB%A7%81-ajax-%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0-%EB%B0%9B%EA%B8%B0/)
 - [JSON parse error: Unrecognized token 문제(Request Body로 보내지는 JSON의 행방 불명)](https://github.com/HomoEfficio/dev-tips/blob/master/Request%20Body%EB%A1%9C%20%EB%B3%B4%EB%82%B4%EC%A7%80%EB%8A%94%20JSON%EC%9D%98%20%ED%96%89%EB%B0%A9%20%EB%B6%88%EB%AA%85.md)
 - [spring security login기능 정리글](https://xmfpes.github.io/spring/spring-security/)
 - [Spring boot에서 Spring security를 사용하여 로그인 하기](https://wedul.site/170)
