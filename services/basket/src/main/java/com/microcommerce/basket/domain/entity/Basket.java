package com.microcommerce.basket.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("Product")
public class Basket implements Serializable {

    @Id
    private String id;
    private List<Product> products;
    private BigDecimal totalPrice;

    public void setTotalPrice() {
        BigDecimal total = null;

        for (Product item: products) {
            total = total.add(item.getPrice());
        }

        totalPrice = total;
    }
    public BigDecimal getTotalPrice() {
        BigDecimal total = null;

        for (Product item: products) {
            total = total.add(item.getPrice());
        }

        return total;
    }

}
