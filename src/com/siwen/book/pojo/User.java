package com.siwen.book.pojo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String uname;
    private String pwd;
    private String email;
    private Integer role;
    private Cart cart;
    private List<OrderBean> orderBeanList;

    public User(Integer id) {
        this.id = id;
    }
}
