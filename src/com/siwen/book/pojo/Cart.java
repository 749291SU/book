package com.siwen.book.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.book.pojo
 * @className: Cart
 * @author: 749291
 * @description: TODO
 * @date: 4/1/2023 8:40 PM
 * @version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Map<Integer, CartItem> cartItemMap;
    private Integer totalCount;
    private Integer totalBookCount;
    private Double totalMoney;

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Integer getTotalCount() {
        return totalCount = cartItemMap == null ? 0 : cartItemMap.size();
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        for (Map.Entry<Integer, CartItem> entry : cartItemMap.entrySet()) {
            totalMoney += entry.getValue().getBook().getPrice() * entry.getValue().getBuyCount();
        }
        return totalMoney;
    }

    public Integer getTotalBookCount() {
        if (totalBookCount != null) return totalBookCount;
        totalBookCount = 0;
        for (Map.Entry<Integer, CartItem> entry : cartItemMap.entrySet()) {
            totalBookCount += entry.getValue().getBuyCount();
        }
        return totalBookCount;
    }
}
