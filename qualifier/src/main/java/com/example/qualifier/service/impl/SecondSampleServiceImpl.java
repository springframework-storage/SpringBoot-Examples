package com.example.qualifier.service.impl;

import com.example.qualifier.service.SampleService;
import org.springframework.stereotype.Service;

@Service("secondSampleService")
public class SecondSampleServiceImpl implements SampleService {

  @Override
  public String print(String msg) {
    return "Second" + msg;
  }

}
