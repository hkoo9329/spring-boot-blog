
## 에러 유형

### The server time zone value ‘KST’ is unrecognized or represents more than one time zone : mysql-connector-java 버전 5.1.X 이후 버전부터 KST 타임존을 인식하지 못하는 이슈

>  The server time zone value ‘KST’ is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.



- 해결 

  1. 스프링 부트 설정 파일에 serverTimezone=UTC&useLegacyDatetimeCode=false 를 추가

     ```yaml
     spring.datasource.url=jdbc:mysql://127.0.0.1:3306/avmaint-local?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
     
     
     ```

  2. mysql 에서 타임존 추가

     ```sql
     default_time_zone='+03:00'
     sudo service mysql restart
     ```

     - 또는 mysql 서버의 타임존을 “**Asia/Seoul**” 로 지정 (http://blog.naver.com/wizardkyn/220852348757)



###  LOADING CLASS `COM.MYSQL.JDBC.DRIVER’. THIS IS DEPRECATED. THE NEW DRIVER CLASS IS `COM.MYSQL.CJ.JDBC.DRIVER’. THE DRIVER IS AUTOMATICALLY REGISTERED VIA THE SPI AND MANUAL LOADING OF THE DRIVER CLASS IS GENERALLY UNNECESSARY.

> ​	: driver 이름 변경 필요

- 해결

  - driver 명 수정

    

    - 변경 전: com.mysql.jdbc.Driver
    - 변경 후: com.mysql.cj.jdbc.Driver



> 출처 : [https://yenaworldblog.wordpress.com/2018/01/24/java-mysql-%EC%97%B0%EB%8F%99%EC%8B%9C-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EC%97%90%EB%9F%AC-%EB%AA%A8%EC%9D%8C/](https://yenaworldblog.wordpress.com/2018/01/24/java-mysql-연동시-발생하는-에러-모음/)


## 추후 정리
> 출처 : https://okky.kr/article/333904?note=1082194
> 출처 : https://okky.kr/article/441805