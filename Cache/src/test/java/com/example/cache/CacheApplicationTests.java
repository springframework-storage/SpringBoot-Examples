package com.example.cache;

import com.example.cache.repository.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

  @Autowired
  private BookRepository bookRepository;

  private long startTime;
  private long endTime;

  private static final Logger logger = LoggerFactory.getLogger(CacheApplicationTests.class);

  @Before
  public void onBefore() {
    startTime = System.currentTimeMillis();
  }

  @After
  public void onAfter() {
    endTime = System.currentTimeMillis();
    logger.info("### 소요시간: {} ms", endTime - startTime);
  }

  @Test
  public void test1() {
    bookRepository.getByIsbn("a");
  }

  @Test
  public void test2() {
    bookRepository.getByIsbn("a");
  }

  @Test
  public void test3() {
    bookRepository.getByIsbn("b");
  }

  @Test
  public void test4() {
    bookRepository.getByIsbn("a");
  }

  @Test
  public void test5() {
    bookRepository.refresh("a");
    bookRepository.getByIsbn("a");
  }

}
