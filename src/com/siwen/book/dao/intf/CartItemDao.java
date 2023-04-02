package com.siwen.book.dao.intf;

import com.siwen.book.pojo.CartItem;
import com.siwen.book.pojo.User;

import java.util.List;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    List<CartItem> getCartItemList(User userBean);
}
