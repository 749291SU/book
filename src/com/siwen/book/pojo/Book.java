package com.siwen.book.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private Integer id;
    private String bookImg;
    private String bookName;
    private Double price;
    private String author;
    private Integer saleCount;
    private Integer bookCount;
    private Integer bookStatus = 0;

    public Book(Integer id) {
        this.id = id;
    }
}
