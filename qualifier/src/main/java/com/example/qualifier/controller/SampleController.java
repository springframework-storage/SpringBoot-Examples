package com.example.qualifier.controller;

import com.example.qualifier.service.SampleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class SampleController {

  private final SampleService firstSampleService;
  private final SampleService secondSampleService;

  public SampleController(@Qualifier("firstSampleService") SampleService firstSampleService,
                          @Qualifier("secondSampleService") SampleService secondSampleService) {
    this.firstSampleService = firstSampleService;
    this.secondSampleService = secondSampleService;
  }

  @RequestMapping("first")
  public String firstSample() {
    return firstSampleService.print("GitFlow");
  }

  @RequestMapping("second")
  public String secondSample() {
    return secondSampleService.print("GitFlow");
  }

}
