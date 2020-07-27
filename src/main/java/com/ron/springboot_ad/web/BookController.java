package com.ron.springboot_ad.web;

import com.ron.springboot_ad.domain.Book;
import com.ron.springboot_ad.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }

//    @ExceptionHandler({Exception.class})
//    public ModelAndView handleException(HttpServletRequest request,Exception e) throws Exception {
//        logger.error("Request URL : {} , Exception : {}",request.getRequestURL(),e.getMessage());
//
//        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
//            throw e;
//        }
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("url", request.getRequestURL());
//        mav.addObject("exception", e);
//        mav.setViewName("error/error");
//
//        return mav;
//    }
}
