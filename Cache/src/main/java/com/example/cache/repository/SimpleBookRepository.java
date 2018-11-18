package com.example.cache.repository;

import com.example.cache.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

  private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);

  /**
   * @Cacheable : 캐시 생성
   * value : 캐시 이름
   * key : 키
   *
   * @param isbn
   * @return
   */
  @Override
  @Cacheable(value = "book", key = "#isbn")
  public Book getByIsbn(String isbn) {
    slowService();
    return new Book(isbn, "NEW BOOK");
  }

  /**
   * @CacheEvict : 캐시 초기화
   * value : 캐시 이름
   * key : 키
   *
   * @param isbn
   */
  @Override
  @CacheEvict(value = "book", key = "#isbn")
  public void refresh(String isbn) {
    logger.info("### cache clear => {}", isbn);
  }

  private void slowService() {
    try {
      long time = 3000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

}
