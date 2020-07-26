package com.ron.springboot_ad.service;

import com.ron.springboot_ad.domain.Book;
import com.ron.springboot_ad.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
//    public Optional<Book> getBookById(Long id) {
//        Optional<Book> book = bookRepository.findById(id);
//        return book;
//    }
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }
}
