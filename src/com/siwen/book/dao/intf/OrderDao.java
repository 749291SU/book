package com.siwen.book.dao.intf;

import com.siwen.book.pojo.OrderBean;
import com.siwen.book.pojo.User;

import java.util.List;

public interface OrderDao {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderBeanList(User user);

    Integer getOrderTotalBookCount(OrderBean orderbean);

    OrderBean packOrderBean(OrderBean orderBean);
}