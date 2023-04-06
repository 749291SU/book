package com.siwen.book.pojo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderBean {
    private Integer id;
    private String orderNo;
    private LocalDateTime orderDate;
    private User orderUser;
    private Double orderMoney;
    private Integer orderStatus;
    private Integer totalBookCount;
    private List<OrderItem> orderItemList;

    public OrderBean(Integer id) {
        this.id = id;
    }
}
