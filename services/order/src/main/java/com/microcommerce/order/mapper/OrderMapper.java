package com.microcommerce.order.mapper;

import com.microcommerce.order.domain.dto.OrderDetailResponse;
import com.microcommerce.order.domain.dto.OrderRequest;
import com.microcommerce.order.domain.dto.OrderResponse;
import com.microcommerce.order.domain.entity.Order;
import com.microcommerce.order.domain.entity.OrderDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;

    public OrderResponse mapOrderToOrderResponse(Order order) {
        List<OrderDetailResponse> orderDetailResponses = order
                .getOrderDetailList()
                .stream()
                .map(orderDetailMapper::mapOrderDetailToOrderDetailResponse)
                .toList();

        return OrderResponse
                .builder()
                .id(order.getId())
                .username(order.getUsername())
                .email(order.getEmail())
                .orderDetailList(orderDetailResponses)
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

    public List<OrderResponse> mapOrdersToOrderResponses(List<Order> orders) {
        return orders
                .stream()
                .map(this::mapOrderToOrderResponse)
                .toList();
    }

    public Order mapOrderRequestToOrder(OrderRequest orderRequest) {
        List<OrderDetail> orderDetails = orderRequest
                .getOrderDetailList()
                .stream()
                .map(orderDetailMapper::mapOrderDetailRequestToOrderDetail)
                .toList();

        return Order
                .builder()
                .orderDetailList(orderDetails)
                .build();
    }


}
