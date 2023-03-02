package com.microcommerce.order.domain.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {

    private String id;
    private String email;
    private List<OrderDetailPlacedEvent> orderDetail;

}
