# SpringBoot - CORS
브라우저 초기에 보안상의 이유로 스크립트 내에서 시작된 교착 출처 HTTP 요청을 제한하는데,<br>
 이를 **SOP(Same-Origin Policy, 동일 출처 정책)** 라 한다.
 
## 동일 출처
SOP 는 두 Origin 간에 프로토콜, 포트, 호스트가 같아야 동일 Origin 이라고 할 수 있다.
* 예를 들어 ```http://www.gitflow.org```이라는 URL 이 있다면 다음과 같은 상황이 발생한다.
    * ```http://www.gitflow.org/user``` (성공)
    * ```httsp://www.gitflow.org``` (실패 - 프로토콜 상이)
    * ```http://www.gitflow.org:8080``` (실패 - 포트 상이)
    * ```http://blog.gitflow.org``` (실패 - 호스트 상이)
    
---

## CORS
그래서 이를 보완하기 위해 브라우저 측에서 JSONP 를 사용하거나, 서버 측에서 **CORS**를 이용하여 해결할 수 있다.<br>
여기서 **CORS(Cross-Origin Resource Sharing)** 란, 웹 서버 도메인 간 액세스 제어 기능을 제공하여 보안 도메인 간 데이터 전송을 가능하게 한다.

### CORS 동작 과정
1. pre-flight : 실제 요청하려는 경로와 같은 URL 에 대해 OPTIONS 로 요청을 날려보고 요청가능한지 확인
2. 실제 요청

---

## Spring Boot 에서 활용하기
우선 서버에서는 브라우저에 다음과 같은 키를 **header**에 보내줘야 한다.
* ```Access-Control-Allow-Origin``` : 요청을 보내는 페이지의 출처 (*, 도메인)
* ```Access-Control-Allow-Methods``` : 요청을 허용하는 메소드 (DEFAULT: GET, POST, HEAD)
* ```Acess-Control-Max-Age``` : 클라이언트에서 pre-flight 의 요청 결과를 저장할 시간 지정 (해당 시간 동안은 pre-flight 를 다시 요청하지 않는다.)
* ```Access-Control-Allow-Headers``` : 요청을 허용하는 헤더

그리고 Spring 과 Spring Boot 에서는 다음 2가지 방법으로 CORS 를 해결할 수 있다.
* Controller 지정
개별적으로 허용하는 방법으로는 ```@CrossOrigin```을 사용하는 것이다.<br>
[CrossOrigin_Controller](./src/main/java/com/example/cors/controller/MessageController.java)

* Global 하게 지정
```WebMvcConfigurer```를 구현하거나 다음과 같이 ```@Bean```으로 등록하여 ```addCorsMappings```에 원하는 path 를 추가하면 된다.<br>
[WebMvcConfigurer](./src/main/java/com/example/cors/config/WebConfig.java)
