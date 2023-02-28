package com.microcommerce.basket.controller;


import com.microcommerce.basket.domain.dto.BasketRequest;
import com.microcommerce.basket.domain.dto.BasketResponse;
import com.microcommerce.basket.service.BasketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping()
    public ResponseEntity<BasketResponse> findById() {
        BasketResponse basketResponse = basketService.find();
        return ResponseEntity.status(HttpStatus.OK).body(basketResponse);
    }

    @PostMapping
    public ResponseEntity<BasketResponse> save(@Valid @RequestBody BasketRequest brandRequest) {
        BasketResponse basketResponse = basketService.save(brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(basketResponse);
    }

    @DeleteMapping("")
    public ResponseEntity<Boolean> delete() {
        boolean result = basketService.delete();
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}

