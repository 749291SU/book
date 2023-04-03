package com.siwen.book.services.impl;

import com.siwen.book.dao.intf.CartItemDao;
import com.siwen.book.dao.intf.OrderDao;
import com.siwen.book.dao.intf.OrderItemDao;
import com.siwen.book.pojo.CartItem;
import com.siwen.book.pojo.OrderBean;
import com.siwen.book.pojo.OrderItem;
import com.siwen.book.pojo.User;
import com.siwen.book.services.intf.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.services.impl
 * @className: OrderServiceImpl
 * @author: 749291
 * @description: TODO
 * @date: 4/3/2023 8:19 PM
 * @version: 1.0
 */

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private OrderItemDao orderItemDao;
    private CartItemDao cartItemDao;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        orderDao.addOrderBean(orderBean);

        List<OrderItem> orderItemList = orderBean.getOrderItemList();
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderBean(orderBean);
            orderItemDao.addOrderItem(orderItem);
        }

        User orderUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = orderUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDao.deleteCartItem(cartItem);
        }
    }
}