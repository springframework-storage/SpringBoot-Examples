package com.example.cors.controller;

import com.example.cors.domain.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msg")
public class MessageController {

  @CrossOrigin("*")
  @GetMapping("{value}")
  public String getTest(@PathVariable("value") String value) {
    return value;
  }

  @PostMapping
  public Message postTest(@RequestBody Message message) {
    return message;
  }

}
