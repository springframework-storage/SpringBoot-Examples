package com.example.test.service.impl;

import com.example.test.domain.TestMessage;
import com.example.test.service.BasicService;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

  @Override
  public String test(int flag) {
    return flag == 0 ? "Spring Boot Service TEST" : "";
  }

  @Override
  public TestMessage jsonTest() {
    return new TestMessage("gitflow", 0);
  }

}
