package com.microcommerce.order.repository;

import com.microcommerce.order.domain.entity.Order;
import com.microcommerce.order.domain.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
