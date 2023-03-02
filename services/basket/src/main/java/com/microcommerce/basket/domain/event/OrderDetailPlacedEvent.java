package com.microcommerce.basket.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailPlacedEvent {
    private String id;
    private BigDecimal price;
    private Integer quantity;
}
