package com.microcommerce.product.controller;

import com.microcommerce.product.domain.dto.ProductRequest;
import com.microcommerce.product.domain.dto.ProductResponse;
import com.microcommerce.product.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String id) {
        ProductResponse productResponse = productService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping("/is-in-stock/{id}")
    @RolesAllowed({"admin"})
    public ResponseEntity<Boolean> isInStock(@PathVariable String id) {
        Boolean response = productService.isInStock(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllPaginated(@RequestParam("page") Integer page) {
        List<ProductResponse> productResponses = productService.findAllPaginated(page);
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> insert(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.insert(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable String id,
            @Valid @RequestBody ProductRequest productRequest
    ) {
        ProductResponse productResponse = productService.update(id, productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean result = productService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
