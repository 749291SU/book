package com.siwen.book.dao.impl;

import com.siwen.book.dao.intf.OrderDao;
import com.siwen.book.pojo.OrderBean;
import com.siwen.myssm.basedao.BaseDao;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.dao.impl
 * @className: OrderDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 4/3/2023 8:06 PM
 * @version: 1.0
 */

public class OrderDaoImpl extends BaseDao<OrderBean> implements OrderDao {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        Integer id = super.update("INSERT INTO t_order VALUES (0, ?, ?, ?, ?, ?)",
                orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOrderUser().getId(),
                orderBean.getOrderMoney(), orderBean.getOrderStatus());
        orderBean.setId(id);
    }
}