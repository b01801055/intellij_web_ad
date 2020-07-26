package com.ron.springboot_ad.service;

import com.ron.springboot_ad.domain.Book;

public interface BookService {

    Book getBookById(Long id);
}
