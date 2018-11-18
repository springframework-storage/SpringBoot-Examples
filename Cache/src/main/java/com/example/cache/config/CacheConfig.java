package com.example.cache.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableCaching 을 명시해주면 바로 사용할 수 있고 추가적인 설정이 없다면
 * ConcurrentMap 을 사용하여 Caching 하게 된다.
 * 또한 Redis 나 Ehcache 라이브러리를 추가하면 Spring Boot 의 Auto Detect 기능으로 인해
 * 해당 라이브러리를 자동으로 사용하게 된다.
 */

@Configuration
@EnableCaching
public class CacheConfig {
}
