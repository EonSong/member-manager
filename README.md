# 06.23 오류해결

### aplication.properties
```
spring.datasource.jdbc-url=jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=Thdtkddjs1!

mybatis.mapper-locations=classpath:mapper/*.xml
```
## 수정내용 : 
```
spring.datasource.url -> spring.datasource.jdbc-url
mybatis.mapper-locations=classpath:mapper/*.xml 추가
```

## TABLE 및 INSERT script
```sql
CREATE TABLE `member` (
  `no` int NOT NULL AUTO_INCREMENT,
  `team` varchar(100) COLLATE utf8_bin NOT NULL,
  `position` varchar(100) COLLATE utf8_bin NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `phone` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
```

```sql
insert into member values(null, '스마트서비스개발팀', '사원', '송상언', 'sesong', '010-9179-5332');
insert into member values(null, 'TV플랫폼서비스개발팀', '대리', '송정원', 'jwsong', '010-3395-8002');
insert into member values(null, 'TV플랫폼서비스개발팀', '사원', '이은선', 'eslee', '010-3705-5106');
```

## 테스트 방법
localhost:8080 으로 
try1 페이지 확인후
localhost:8080/all 로 
디비 출력확인

aplication.properties
저는 아래처럼 작성했습니다.
```sql
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=Thdtkddjs1!
```

### 테스트해본것

MemberService 에서 getAll() 함수를 주석처리되어있는
```sql
//        List<MemberInfo> memberList = new ArrayList<MemberInfo>();
//
//        memberList.add(new MemberInfo("1","경영기획부","대리","송상언","email.com","010-1111-1111"));
//        memberList.add(new MemberInfo("2","경영기획부","사원","홍길동","email.com","010-1111-1111"));
//        memberList.add(new MemberInfo("3","인사팀","과장","장희영","email.com","010-1111-1111"));
```
로 바꿔 memberList 리턴시 정상출력되는것 확인했습니다.
아마 dao혹은 mapper쪽 문제같습니다
