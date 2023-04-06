package com.siwen.book.dao.impl;

import com.siwen.book.dao.intf.OrderDao;
import com.siwen.book.pojo.OrderBean;
import com.siwen.book.pojo.User;
import com.siwen.myssm.basedao.BaseDao;

import java.util.List;

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

    @Override
    public List<OrderBean> getOrderBeanList(User user) {
        List<OrderBean> query = super.query("SELECT * FROM t_order WHERE orderUser = ?", user.getId());
        query.replaceAll(this::packOrderBean);
        return query;
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        return super.query("SELECT t1.id FROM t_order t1 JOIN t_order_item t2 WHERE t1.id = t2.orderBean and t1.orderUser = ? and t1.id = ?",
                orderBean.getOrderUser().getId(), orderBean.getId()).size();
    }

    @Override
    public OrderBean packOrderBean(OrderBean orderBean) {
        orderBean.setTotalBookCount(getOrderTotalBookCount(orderBean));
        return orderBean;
    }
}