package com.example.test;

import com.example.test.service.BasicService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @MockBean
  private BasicService basicService;

  @Test
  public void test1() {
    given(basicService.test(0))
            .willReturn("Spring Boot Service TEST");

    String result = testRestTemplate.getForObject("/test?flag=0", String.class);
    Assert.assertEquals(result, "Spring Boot Service TEST");
  }

  @Test
  public void mockTest() {
    given(basicService.test(0))
            .willReturn("Spring Boot Service TEST");

    Assert.assertEquals(basicService.test(0), "Spring Boot Service TEST");
  }

}
