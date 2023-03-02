package com.microcommerce.order.service;


import com.microcommerce.order.domain.dto.OrderRequest;
import com.microcommerce.order.domain.dto.OrderResponse;
import com.microcommerce.order.domain.entity.Order;
import com.microcommerce.order.exception.ApiException;
import com.microcommerce.order.mapper.OrderMapper;
import com.microcommerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponse> findAll() {
        List<Order> orders = orderRepository.findAll();

        log.info("Order list returned");
        return orderMapper.mapOrdersToOrderResponses(orders);
    }

    public OrderResponse findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty()) {
            throw new ApiException("Order not found with id: {0}", id);
        }

        log.info("Order found with id: " + id);
        return orderMapper.mapOrderToOrderResponse(order.get());
    }

    public boolean delete(Integer id) {
        if (!orderRepository.existsById(id)) {
            throw new ApiException("Order not found with id: {0}", id);
        }

        orderRepository.deleteById(id);

        log.info("Order deleted with id: " + id);
        return true;
    }
}
