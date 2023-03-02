package com.microcommerce.order.mapper;

import com.microcommerce.order.domain.entity.Order;
import com.microcommerce.order.domain.entity.OrderDetail;
import com.microcommerce.order.domain.event.OrderPlacedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderPlacedMapper {

    public Order mapOrderPlacedEventToOrder(OrderPlacedEvent orderPlacedEvent){
        List<OrderDetail> orderDetailList = orderPlacedEvent
                .getOrderDetail()
                .stream()
                .map(orderDetailPlacedEvent -> OrderDetail
                        .builder()
                        .productId(orderDetailPlacedEvent.getId())
                        .price(orderDetailPlacedEvent.getPrice())
                        .quantity(orderDetailPlacedEvent.getQuantity())
                        .build()
                )
                .toList();

        return Order
                .builder()
                .username(orderPlacedEvent.getId())
                .email(orderPlacedEvent.getEmail())
                .orderDetailList(orderDetailList)
                .build();
    }

}
