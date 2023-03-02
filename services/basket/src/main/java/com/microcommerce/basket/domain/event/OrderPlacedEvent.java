package com.microcommerce.basket.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private String id;
    private String email;
    private List<OrderDetailPlacedEvent> orderDetail;
}
