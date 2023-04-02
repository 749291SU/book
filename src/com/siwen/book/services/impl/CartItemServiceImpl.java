package com.siwen.book.services.impl;

import com.siwen.book.dao.intf.CartItemDao;
import com.siwen.book.pojo.Cart;
import com.siwen.book.pojo.CartItem;
import com.siwen.book.pojo.User;
import com.siwen.book.services.intf.BookService;
import com.siwen.book.services.intf.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.services.impl
 * @className: CartItemServiceImpl
 * @author: 749291
 * @description: TODO
 * @date: 4/1/2023 8:39 PM
 * @version: 1.0
 */

public class CartItemServiceImpl implements CartItemService {
    private CartItemDao cartItemDao;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDao.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap != null) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                if (cartItemTemp != null) {
                    cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                    updateCartItem(cartItemTemp);
                } else addCartItem(cartItem);
            } else addCartItem(cartItem);
        } else addCartItem(cartItem);
    }

    @Override
    public List<CartItem> getCartItemList(User userBean) {
        List<CartItem> cartItemList = cartItemDao.getCartItemList(userBean);
        for (int i = 0; i < cartItemList.size(); i++) {
            cartItemList.set(i, packCartItem(cartItemList.get(i)));
        }
        return cartItemList;
    }

    @Override
    public Cart getCart(User userBean) {
        List<CartItem> cartItemList = getCartItemList(userBean);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook().getId(), cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }

    @Override
    public CartItem packCartItem(CartItem cartItem) {
        cartItem.setBook(bookService.getBook(cartItem.getBook().getId()));
        return cartItem;
    }
}