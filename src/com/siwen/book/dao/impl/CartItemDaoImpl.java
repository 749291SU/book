package com.siwen.book.dao.impl;

import com.siwen.book.dao.intf.CartItemDao;
import com.siwen.book.pojo.CartItem;
import com.siwen.book.pojo.User;
import com.siwen.myssm.basedao.BaseDao;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.dao.impl
 * @className: CartItemDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 4/1/2023 8:47 PM
 * @version: 1.0
 */

public class CartItemDaoImpl extends BaseDao<CartItem> implements CartItemDao {
    @Override
    public void addCartItem(CartItem cartItem) {
        super.update("INSERT INTO t_cart_item(book, buyCount, userBean) VALUES(?, ?, ?)",
                cartItem.getBook().getId(), cartItem.getBuyCount(), cartItem.getUserBean().getId());
    }


    @Override
    public void updateCartItem(CartItem cartItem) {
        super.update("UPDATE t_cart_item SET buyCount = ? WHERE userBean = ? AND book = ? ",
                cartItem.getBuyCount(), cartItem.getUserBean().getId(), cartItem.getBook().getId());
    }

    @Override
    public List<CartItem> getCartItemList(User userBean) {
        return super.query("SELECT * FROM t_cart_item WHERE userBean = ?", userBean.getId());
    }

    @Override
    public void deleteCartItem(CartItem cartItem) {
        super.update("DELETE FROM t_cart_item WHERE id = ?", cartItem.getId());
    }
}