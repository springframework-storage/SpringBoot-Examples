# SpringBoot - Interceptor
Url Mapping 된 Controller 를 거치기 전, 후 처리를 할 수 있도록 도와주는 요소를 말한다.<br>
세션 검증, 로그 처리 같은 행위가 간단한 예시가 될 수 있다.<br><br>

Interceptor 후처리를 이용하여 값을 가공하거나 header 에 키값을 추가하는 등의 작업은 할 수 없다.<br>
이 경우 **ResponseBodyAdvice** 를 구현해야 한다.<br>
[HttpResponseAdvice](/src/main/java/com/example/interceptor/advice/HttpResponseAdvice.java)