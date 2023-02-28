package com.microcommerce.basket.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketResponse {
    private String id;
    private List<ProductResponse> products;
    private BigDecimal totalPrice;

    public void setTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0);

        for (ProductResponse item: products) {
            total = total.add(item.getPrice());
        }

        totalPrice = total;
    }
    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0);

        for (ProductResponse item: products) {
            total = total.add(item.getPrice());
        }

        return total;
    }
}
