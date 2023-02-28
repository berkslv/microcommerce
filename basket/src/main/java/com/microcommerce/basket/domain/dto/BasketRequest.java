package com.microcommerce.basket.domain.dto;

import jakarta.validation.constraints.Null;
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
public class BasketRequest {
    private List<ProductRequest> products;
    @Null
    private BigDecimal totalPrice;
    public void setTotalPrice() {}
    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.valueOf(0);

        for (ProductRequest item: products) {
            total = total.add(item.getPrice());
        }

        return total;
    }

}
