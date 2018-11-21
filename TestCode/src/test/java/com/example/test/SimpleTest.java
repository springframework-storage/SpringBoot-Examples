package com.example.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

  private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

  @BeforeClass
  public static void onBeforeClass() {
    logger.info("### onBeforeClass()");
  }

  @AfterClass
  public static void onAfterClass() {
    logger.info("### onAfterClass()");
  }

  @Before
  public void onBefore() {
    logger.info("### onBefore()");
  }

  @After
  public void onAfter() {
    logger.info("### onAfter()");
  }

  @Test
  public void test1() {
    logger.info("### test1()");
    Assert.assertSame(add(1, 2), 3);
  }

  @Test
  public void test2() {
    logger.info("### test2()");
    Assert.assertSame(add(0, 0), 0);
  }

  private int add(int num1, int num2) {
    return num1 + num2;
  }

}
