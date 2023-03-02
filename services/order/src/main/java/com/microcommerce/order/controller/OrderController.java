package com.microcommerce.order.controller;

import com.microcommerce.order.domain.dto.OrderRequest;
import com.microcommerce.order.domain.dto.OrderResponse;
import com.microcommerce.order.security.SecurityUtil;
import com.microcommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final SecurityUtil securityUtil;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<OrderResponse> orderResponses = orderService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(orderResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable("id") Integer id) {
        OrderResponse orderResponse = orderService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
        Boolean result = orderService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }






}
