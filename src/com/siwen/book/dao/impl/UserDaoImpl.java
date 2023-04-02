package com.siwen.book.dao.impl;

import com.siwen.book.dao.intf.UserDao;
import com.siwen.book.pojo.User;
import com.siwen.myssm.basedao.BaseDao;
import org.thymeleaf.util.ListUtils;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: som.siwen.book.dao.impl
 * @className: UserDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 3/31/2023 10:26 PM
 * @version: 1.0
 */

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User getUser(String uname, String pwd) {
        List<User> userList = super.query("SELECT * FROM t_user WHERE uname = ? AND pwd = ?", uname, pwd);
        return ListUtils.isEmpty(userList) ? null : userList.get(0);
    }
}
