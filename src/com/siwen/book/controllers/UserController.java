package com.siwen.book.controllers;

import com.siwen.book.pojo.Cart;
import com.siwen.book.pojo.User;
import com.siwen.book.services.intf.CartItemService;
import com.siwen.book.services.intf.UserService;

import javax.servlet.http.HttpSession;

/**
 * @projectName: JavaWeb
 * @package: som.siwen.book.controllers
 * @className: UserController
 * @author: 749291
 * @description: TODO
 * @date: 3/31/2023 10:20 PM
 * @version: 1.0
 */

public class UserController {
    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session) {
        User user = userService.getUser(uname, pwd);
        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("curUser", user);
            return "redirect:book.do";
        } else return "render:user/login";
    }
}