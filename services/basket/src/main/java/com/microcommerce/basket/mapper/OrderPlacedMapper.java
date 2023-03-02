package com.microcommerce.basket.mapper;

import com.microcommerce.basket.domain.dto.ProductResponse;
import com.microcommerce.basket.domain.entity.Basket;
import com.microcommerce.basket.domain.event.OrderDetailPlacedEvent;
import com.microcommerce.basket.domain.event.OrderPlacedEvent;
import com.microcommerce.basket.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderPlacedMapper {

    private final SecurityUtil securityUtil;

    public OrderPlacedEvent mapBasketToOrderPlacedEvent(Basket basket) {
        List<OrderDetailPlacedEvent> orderDetailPlacedEventList = basket
                .getProducts()
                .stream()
                .map(product -> OrderDetailPlacedEvent
                        .builder()
                        .id(product.getId())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build()
                ).toList();

        return OrderPlacedEvent
                .builder()
                .id(basket.getId())
                .email(securityUtil.getEmail())
                .orderDetail(orderDetailPlacedEventList)
                .build();
    }

}
