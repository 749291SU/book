package com.siwen.book.services.intf;

import com.siwen.book.pojo.Cart;
import com.siwen.book.pojo.CartItem;
import com.siwen.book.pojo.User;

import java.util.List;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);
    List<CartItem> getCartItemList(User userBean);
    Cart getCart(User userBean);
}
