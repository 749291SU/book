package com.siwen.book.pojo;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderBean {
    private Integer id;
    private String orderNo;
    private Date orderDate;
    private User orderUser;
    private Double orderMoney;
    private Integer orderStatus;
    private List<OrderItem> orderItemList;

    public OrderBean(Integer id) {
        this.id = id;
    }
}
