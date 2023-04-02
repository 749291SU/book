package com.siwen.book.dao.intf;

import com.siwen.book.pojo.User;

public interface UserDao {
    User getUser(String uname, String pwd);
}