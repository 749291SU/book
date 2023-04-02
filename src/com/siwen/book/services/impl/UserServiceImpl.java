package com.siwen.book.services.impl;

import com.siwen.book.dao.intf.UserDao;
import com.siwen.book.pojo.User;
import com.siwen.book.services.intf.UserService;

/**
 * @projectName: JavaWeb
 * @package: som.siwen.book.services.intf.impl
 * @className: UserServiceImpl
 * @author: 749291
 * @description: TODO
 * @date: 3/31/2023 10:27 PM
 * @version: 1.0
 */

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public User getUser(String uname, String pwd) {
        return userDao.getUser(uname, pwd);
    }
}
