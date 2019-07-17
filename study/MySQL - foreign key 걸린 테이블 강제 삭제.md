# MySQL - foreign key 걸린 테이블 강제 삭제

```sql
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE 테이블이름;
SET FOREIGN_KEY_CHECKS = 1;
```

