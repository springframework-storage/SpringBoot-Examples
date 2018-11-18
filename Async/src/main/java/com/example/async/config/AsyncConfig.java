package com.example.async.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @EnableAsync 만 추가하면 기본적인 설정 끝
 * 하지만, 기본값인 SimpleAsyncTaskExecutor 클래스는 매번 Thread 를 만들어내는 객체이기 때문에
 * Thread Pool 이 아니다.
 * Thread Pool 을 설정하기 위해 AsyncConfigurerSupport 를 상속받아 재구현한다.
 */

@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

  @Override
  public Executor getAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(10);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("gitflow-async-");
    executor.initialize();
    return executor;
  }

}
