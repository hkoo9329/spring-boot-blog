# MySQL 정리







#### 로컬에서 접속 가능한 사용자 추가하기

MySQL 5.7 이상
```mysql
CREATE DATABASE homestead CHARACTER SET utf8 COLLATE utf8_bin;
  
CREATE USER 'homestead'@'localhost' IDENTIFIED BY 'secret' PASSWORD EXPIRE NEVER;
GRANT ALL PRIVILEGES ON homestead.* TO 'homestead'@'localhost';
 
flush privileges;
```

MySQL 5.7 미만
```mysql
CREATE DATABASE homestead CHARACTER SET utf8 COLLATE utf8_bin;
  
GRANT ALL PRIVILEGES ON homestead.* TO 'homestead'@'localhost' IDENTIFIED BY 'secret';
 
flush privileges;
```


출처 : https://www.lesstif.com/pages/viewpage.action?pageId=24445981