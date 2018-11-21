package com.example.test.controller;

import com.example.test.domain.TestMessage;
import com.example.test.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private BasicService basicService;

  @GetMapping("test")
  public String test(@RequestParam("flag") int flag) {
    return basicService.test(flag);
  }

  @GetMapping("jsonTest")
  public TestMessage jsonTest() {
    return basicService.jsonTest();
  }

}
