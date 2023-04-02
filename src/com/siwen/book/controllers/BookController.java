package com.siwen.book.controllers;

import com.siwen.book.pojo.Book;
import com.siwen.book.services.intf.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.controllers
 * @className: BookController
 * @author: 749291
 * @description: TODO
 * @date: 4/1/2023 6:02 PM
 * @version: 1.0
 */

public class BookController {
    private BookService bookService;

    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);
        return "render:index";
    }
}