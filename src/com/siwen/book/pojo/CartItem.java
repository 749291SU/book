package com.siwen.book.pojo;

import lombok.*;

//我们应该还需要设计一个Cart类，代表购物车这个实体
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartItem {
    private Integer id ;
    private Book book ;
    private Integer buyCount ;
    private User userBean ;
    public CartItem(Integer id) {
        this.id = id;
    }
}
