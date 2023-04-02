package com.siwen.book.services.impl;

import com.siwen.book.dao.intf.BookDao;
import com.siwen.book.pojo.Book;
import com.siwen.book.services.intf.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    @Override
    public List<Book> getBookList() {
        return bookDao.getBookList();
    }
}