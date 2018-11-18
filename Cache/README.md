# SpringBoot - Cache
Spring 의 장점 중 PSA(Portable Service Abstractions)라는 것이 있다. 이는 쉬운 서비스 추상화라고 하는데,<br>
각각의 외부 서비스를 간단한 인터페이스만으로 쉽게 사용할 수 있도록 설계되어 있다.<br>
Cache 에서는 Redis, Ehcache, ConcurrentMap 등이 ```CacheManager``` 인터페이스로 추상화되어 있고,<br>
```CacheManager``` 인터페이스를 이용하여 또 다른 cache 라이브러리를 사용할 수도 있다.

## 언제 사용하면 좋을까?
* 무거운 비즈니스 로직을 수행할 때
* 주기적으로 언제나 동일한 데이터를 가져올 때
* RDB 의 부하를 분산하고자 할 때

