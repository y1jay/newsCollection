# 잘 부탁드립니다

> MSA 기반 뉴스 수집서버.

![](../header.png)

## 설치 방법

Docker:

```sh
docker-compose up --build
```

NotDocker:

```sh
cd gateway && ./gradlew build && ./gradlew bootrun
```

```sh
cd eureka && ./gradlew build && ./gradlew bootrun
```

```sh
cd auth && ./gradlew build && ./gradlew bootrun
```

```sh
cd collection && ./gradlew build && ./gradlew bootrun
```

```sh
cd batch && ./gradlew build && ./gradlew bootrun
```

## 사용 예제

<!-- **권한 별 유저**
admin : { user_id : nexon , password : 987987 }<br/>
operator : { user_id : y11 , password : 0531 }<br/> -->

GATEWAY http://localhost:8080/<br/>
SERVICE collection,auth,batch <br/>

<!-- 스웨거 경로 http://localhost:8080/ApiDocument#/<br/> -->

## 흐름도

**로그인 POST/auth/join**<br/>
body:{(String)name:이름,(String)email:이메일,(String)uuid:유니크고유값,(String)join_type:로그인방식} <br/>
<br/>

**키워드 등록 POST/collection/keywordInsert**<br/>
body:{(Integer)um_idx:회원 일련번호,(String)keyword:키워드,(String)domain_type:도메인타입(Naver)} <br/>
<br/>

**키워드 리스트 GET/collection/keywordList**<br/>
parma:{(String)keyword:키워드,(String)domain_type:도메인타입(Naver),(Integer)um_idx:회원일련번호,(Integer)page:페이지(1,10)} <br/>
<br/>

**키워드 수정 PATCH/collection/keywordUpdate**<br/>
body:{(Integer)um_idx:회원 일련번호,(String)keyword:키워드,(String)domain_type:도메인타입(Naver)} <br/>
<br/>

**키워드 등록 POST/collection/keywordInsert**<br/>
body:{(Boolean)use_yn:사용여부,(String)keyword:키워드,(String)domain_type:도메인,(Integer)um_idx:회원 일련번호} <br/>
<br/>

## 업데이트 내역

-   1

## Stack

[DB] : MySql<br/>
[Java] : v17<br/>
[Auth] : JWT<br/>
[Spring] : Spring Boot<br/>
[Etc] : MSA & Docker & docker-compose

## 부가 설명\*\*

<br/> 
<!-- - 최대한 관리자 혹은 운영자가 자유롭게 이벤트를 생성 및 수정 할 수 있게 고안하여 설계 및 작업하였습니다.<br/><br/>
- 수정 기능도 있으나 스웨거작업이 빠져있습니다 필요하실 경우 사용해주시면 됩니다.<br/><br/>
- 이벤트 별 지급 조건, 지급 조건 별 보상, 보상 별 아이템 각기 다르게 등록 할 수 있습니다.<br/><br/>
- docker-compose 관련하여 이미지 업로드 및 빌드 & 실행까지는 문제 없이 잘 되었으나<br/><br/>
 중간중간 호스트 문제가 계속 일어나 불안정합니다 포트포워딩까지 해보려 했으나 시간이 모자란 점 양해부탁드립니다<br/><br/>
- enum 은 typeString에서 tree shaking 을 지원하지 않아 사용하지 않았습니다.<br/><br/>
.env파일도 커밋해놓았습니다.<br/> -->
