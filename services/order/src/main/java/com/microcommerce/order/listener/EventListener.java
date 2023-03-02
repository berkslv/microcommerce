package com.microcommerce.order.listener;

import com.microcommerce.order.domain.entity.Order;
import com.microcommerce.order.domain.event.OrderPlacedEvent;
import com.microcommerce.order.mapper.OrderPlacedMapper;
import com.microcommerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventListener {

    private final OrderRepository orderRepository;
    private final OrderPlacedMapper orderPlacedMapper;

    @KafkaListener(topics = "orderPlaceTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        Order order = orderPlacedMapper.mapOrderPlacedEventToOrder(orderPlacedEvent);
        log.info("Order created from basket with kafka event listener. username : " + order.getUsername());
        orderRepository.save(order);
    }

}
