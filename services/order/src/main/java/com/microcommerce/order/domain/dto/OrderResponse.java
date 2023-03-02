package com.microcommerce.order.domain.dto;

import com.microcommerce.order.domain.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Integer id;
    private String username;
    private String email;
    private List<OrderDetailResponse> orderDetailList;
    private Date createdAt;
    private Date updatedAt;
}
