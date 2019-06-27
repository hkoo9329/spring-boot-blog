# spring boot를 이용한 블로그



## 사용 예정 기술

1. 당연히 Spring boot를 이용 version은 2.1.5
2. OAuth2  = > 네이버, 구글, 깃헙, 카카오 정도로 생각중
3. thymeleaf를 공부하고 활용하려고 함
4. 사용자 정보 저장을 위해 mysql을 이용하려고함
5. 그 외 기타 등등 생각나면 추가하도록 함





![](http://www.pickis.co.kr/content/contents/upload/2017-04/58edd86a0f389.JPG)

가 되지 않도록.....


### 진행상황

##### 2019.06.12 : OAuth2 Google, kakko 추가 api에서 redirect 변경 해야함 NAVER는 트러블 개선 필요
##### 2019.06.22 : google, kakao, github OAuth2, 구현 but naver OAuth2는 추후에 추가 예정
##### ~~2019.06.24 : CRUD를 위한 api 서버 생성 -> [https://github.com/leejuhyeok/spring-boot-blog-api]~~
##### 2019.06.25 : data-rest으로 변경 (같은 포트를 사용함으로 CORS를 사용 X , 생성했던 api 서버 repo는 유지)




### 참고 사이트
- kakao api 사이트 : https://developers.kakao.com/
- naver api 사이트 : https://developers.naver.com/main/
- google api 사이트 : https://console.developers.google.com/apis
- 무료 이미지 사이트 : https://pixabay.com/ko/



### 해야할 일

- [ ] MySQL DB에 insert 구성하기
- [ ] Pageable 기능에 대해 변경
- [ ] mysql utf-8 설정을 안해서 고생한 내용 추가

### 정리
 - [필요 코드들](./study/Codes.md)
 - [mysql 연동시 오류 해결 방법](./study/MySQLError.md)