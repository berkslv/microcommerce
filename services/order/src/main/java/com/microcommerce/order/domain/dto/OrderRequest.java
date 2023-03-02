package com.microcommerce.order.domain.dto;

import com.microcommerce.order.domain.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private List<OrderDetailRequest> orderDetailList;
}
