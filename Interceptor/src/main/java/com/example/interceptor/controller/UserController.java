package com.example.interceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @GetMapping
  public ResponseEntity<?> index() {
    String msg = "Hello, USER!";
    logger.info("### " + msg);
    return ResponseEntity.ok()
            .header("controller", "controller")
            .body(msg);
  }

}
