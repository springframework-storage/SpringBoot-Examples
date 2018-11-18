package com.example.async.controller;

import com.example.async.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

  @Autowired
  private BasicService basicService;

  private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

  @GetMapping("async")
  public String goAsync() {
    basicService.onAsync();
    String msg = "Hello Spring Boot Async";
    logger.info(msg);
    logger.info("=================================");
    return msg;
  }

  @GetMapping("sync")
  public String goSync() {
    basicService.onSync();
    String msg = "Hello Spring Boot Sync";
    logger.info(msg);
    logger.info("=================================");
    return msg;
  }

}
