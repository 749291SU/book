package com.siwen.book.dao.intf;

import com.siwen.book.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBookList();

    Book getBook(Integer bookId);
}
