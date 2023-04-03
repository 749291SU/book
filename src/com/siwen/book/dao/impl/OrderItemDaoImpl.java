package com.siwen.book.dao.impl;

import com.siwen.book.dao.intf.OrderItemDao;
import com.siwen.book.pojo.OrderItem;
import com.siwen.myssm.basedao.BaseDao;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.dao.impl
 * @className: OrderItemDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 4/3/2023 8:12 PM
 * @version: 1.0
 */

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.update("INSERT INTO t_order_item VALUES (0, ?, ?, ?)", orderItem.getBook().getId(),
                orderItem.getBuyCount(), orderItem.getOrderBean().getId());
    }
}