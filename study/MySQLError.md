
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


### Mysql UTF-8 설정하기
mysql utf8 설정을 해주지 않아서 spring boot에서 사용자의 name을 가져와 repo에서 sql로 저장할 때 문제가 발생
사용자의 utf8 설정을 해주지 않아서 mysql에 한글로 된 데이터를 넣을라고 하면 프로그램이 다운됐다.

처음에는 [Windows MySQL UTF-8 설정](https://lazymankook.tistory.com/70)  이 사이트를 보고 my,ini 설정 파일을 변경해 봤으나 MySQL 서버가 먹통이 되었다.

> ~~이거 때문에 몇번을 새로 설치했는지.....~~



#### workbench를 이용한 UTF-8설정

결국 사용한 방법은 workbench를 이용한 방법이다.

1. Status and System Variables 메뉴를 들어간다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FclYESG%2FbtqwrR7q9IO%2FNbYF87RNMQRijyG8nAKmQ0%2Fimg.png)



2. System Variables를 누르고

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FdblFRm%2Fbtqwuy5G6k2%2FndKqZQeV05xox1tKqcnTw0%2Fimg.png)



3. character_set을 검색하면 다음과 같은 검색 결과가 나온다. 원래는 value 부분이 utf8이 아니라 다른 설정으로 되어있다. 여기서 value 값을 utf8로 변경하고 Refresh를 눌러서 변경해준다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FKQKHw%2FbtqwtlGfPAb%2FnQJpswILenbnmUN0izI781%2Fimg.png)



## 추후 정리

> 출처 : https://okky.kr/article/333904?note=1082194
> 출처 : https://okky.kr/article/441805