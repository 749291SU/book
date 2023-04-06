package com.siwen.book.services.intf;

import com.siwen.book.pojo.OrderBean;
import com.siwen.book.pojo.User;

import java.util.List;

public interface OrderService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean>getOrderBeanList(User user);
}