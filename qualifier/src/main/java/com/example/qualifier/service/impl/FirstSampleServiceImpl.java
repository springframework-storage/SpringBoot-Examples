package com.example.qualifier.service.impl;

import com.example.qualifier.service.SampleService;
import org.springframework.stereotype.Service;

@Service("firstSampleService")
public class FirstSampleServiceImpl implements SampleService {

  @Override
  public String print(String msg) {
    return "First" + msg;
  }

}
