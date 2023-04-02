package com.siwen.book.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem {
    private Integer id;
    private Book book;                 //M:1
    private Integer buyCount;
    private OrderBean orderBean;       //M:1

    public OrderItem(Integer id) {
        this.id = id;
    }
}
