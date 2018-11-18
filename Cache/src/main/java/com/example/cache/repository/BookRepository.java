package com.example.cache.repository;

import com.example.cache.domain.Book;

public interface BookRepository {

  Book getByIsbn(String isbn);

  void refresh(String isbn);

}
