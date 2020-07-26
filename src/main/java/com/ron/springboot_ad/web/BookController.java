package com.ron.springboot_ad.web;

import com.ron.springboot_ad.domain.Book;
import com.ron.springboot_ad.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return "book";
    }
}
