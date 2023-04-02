package com.siwen.book.services.intf;

import com.siwen.book.pojo.User;

/**
 * @projectName: JavaWeb
 * @package: som.siwen.book.services.intf
 * @className: UserService
 * @author: 749291
 * @description: TODO
 * @date: 3/31/2023 10:27 PM
 * @version: 1.0
 */

public interface UserService {
    User getUser(String uname, String pwd);
}
