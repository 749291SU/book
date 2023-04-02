package com.siwen.book.pojo;

import lombok.*;

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

    public User(Integer id) {
        this.id = id;
    }
}
