package com.microcommerce.order.mapper;

import com.microcommerce.order.domain.dto.OrderDetailRequest;
import com.microcommerce.order.domain.dto.OrderDetailResponse;
import com.microcommerce.order.domain.entity.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDetailMapper {

    public OrderDetailResponse mapOrderDetailToOrderDetailResponse(OrderDetail orderDetail) {
        return OrderDetailResponse
                .builder()
                .id(orderDetail.getId())
                .productId(orderDetail.getProductId())
                .price(orderDetail.getPrice())
                .quantity(orderDetail.getQuantity())
                .build();
    }

    public List<OrderDetailResponse> mapOrderDetailsToOrderDetailResponses(List<OrderDetail> orderDetails) {
        return orderDetails
                .stream()
                .map(this::mapOrderDetailToOrderDetailResponse)
                .toList();
    }

    public OrderDetail mapOrderDetailRequestToOrderDetail(OrderDetailRequest orderDetailRequest) {
        return OrderDetail
                .builder()
                .productId(orderDetailRequest.getProductId())
                .price(orderDetailRequest.getPrice())
                .quantity(orderDetailRequest.getQuantity())
                .build();
    }

}
