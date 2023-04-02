package com.siwen.book.dao.impl;

import com.siwen.book.dao.intf.BookDao;
import com.siwen.book.pojo.Book;
import com.siwen.myssm.basedao.BaseDao;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.dao.impl
 * @className: BookDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 4/1/2023 5:57 PM
 * @version: 1.0
 */

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getBookList() {
        return super.query("SELECT * FROM t_book");
    }
}