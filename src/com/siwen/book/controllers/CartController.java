package com.siwen.book.controllers;

import com.siwen.book.pojo.Book;
import com.siwen.book.pojo.CartItem;
import com.siwen.book.pojo.User;
import com.siwen.book.services.intf.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.controllers
 * @className: CartController
 * @author: 749291
 * @description: TODO
 * @date: 4/1/2023 8:16 PM
 * @version: 1.0
 */

public class CartController {
    private CartItemService cartItemService;

    public String index(HttpSession session) {
        User user = (User) session.getAttribute("curUser");
        user.setCart(cartItemService.getCart(user));
        return "render:cart/cart";
    }

    public String addCart(Integer bookId, HttpSession session) {
        User userBean = (User) session.getAttribute("curUser");
        CartItem cartItem = new CartItem(0, new Book(bookId), 1, userBean);
        cartItemService.addOrUpdateCartItem(cartItem, userBean.getCart());
        return "redirect:cart.do";
    }
}