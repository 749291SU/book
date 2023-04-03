package com.siwen.book.controllers;

import com.siwen.book.pojo.*;
import com.siwen.book.services.intf.OrderService;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.controllers
 * @className: OrderController
 * @author: 749291
 * @description: TODO
 * @date: 4/3/2023 8:49 PM
 * @version: 1.0
 */

public class OrderController {
    private OrderService orderService;
    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo(UUID.randomUUID().toString());
        orderBean.setOrderDate(new Date());
        User curUser = (User) session.getAttribute("curUser");
        orderBean.setOrderUser(curUser);
        orderBean.setOrderMoney(curUser.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        Map<Integer, CartItem> cartItemMap = curUser.getCart().getCartItemMap();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartItem cartItem : cartItemMap.values()) {
            orderItemList.add(new OrderItem(null, new Book(cartItem.getBook().getId()), cartItem.getBuyCount(), null));
        }
        orderBean.setOrderItemList(orderItemList);
        orderService.addOrderBean(orderBean);
        curUser.setCart(new Cart());
        return "render:index";
    }
}
