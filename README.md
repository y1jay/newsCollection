# 잘 부탁드립니다

> 뉴스 수집.

![](../header.png)

## 설치 방법

Docker:

```sh
docker-compose up --build
```

NotDocker:

<!-- ```sh
cd gateway_nexon && npm install cd ../auth_nexon && npm install cd ../event_nexon && npm install
```

```sh
cd gateway_nexon && npm start cd auth_nexon && npm install cd event_nexon && npm install
``` -->

## 사용 예제

<!-- **권한 별 유저**
admin : { user_id : nexon , password : 987987 }<br/>
operator : { user_id : y11 , password : 0531 }<br/> -->

GATEWAY http://localhost:8080/<br/>
SERVICE collection,auth,batch <br/>
스웨거 경로 http://localhost:8080/ApiDocument#/<br/>

## 흐름도

<!--
**이벤트 종류**<br/>
quiz : OX형 퀴즈 <br/>
rand : 문답형 퀴즈<br/>

**유저**<br/>
유저 가입(USER) > 등급 부여

**이벤트 등록**<br/>
이벤트 등록 > 지급 조건 등록(quiz,rand) > 보상 정보 등록 > 아이템 등록

**이벤트 실행**<br/>
유저 : 이벤트 리스트 조회 > 이벤트 실행 1차(문제 제출) <br/> 이벤트 실행 2차(답변) > 성공시 보상요청 조회<br/>
관리자 : 유저 보상 요청 조회 > 보상 지급 (보상지급은 이벤트 고유번호만 넣으면 일괄처리 됩니다.) -->

## 업데이트 내역

-   1

## Stack

[DB] : MySql
[Java] : v17
[Auth] : JWT
[Spring] : Spring Boot
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
