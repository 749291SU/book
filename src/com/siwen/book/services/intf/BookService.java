package com.siwen.book.services.intf;

import com.siwen.book.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookList();

    Book getBook(Integer bookId);
}
