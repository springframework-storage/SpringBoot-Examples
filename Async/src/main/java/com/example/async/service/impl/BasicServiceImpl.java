package com.example.async.service.impl;

import com.example.async.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 비동기 작업을 하기 위한 메소드에 @Async 를 추가하면 된다.
 * callback 이 필요하다면 Future 클래스 등의 객체로 감싸 return 하면 된다.
 */

@Service
public class BasicServiceImpl implements BasicService {

  private static final Logger logger = LoggerFactory.getLogger(BasicServiceImpl.class);

  @Async
  @Override
  public void onAsync() {
    try {
      Thread.sleep(1000);
      logger.info("### onAsync");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onSync() {
    try {
      Thread.sleep(1000);
      logger.info("# onSync");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
