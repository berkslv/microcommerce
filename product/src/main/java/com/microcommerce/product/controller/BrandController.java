package com.microcommerce.product.controller;

import com.microcommerce.product.domain.dto.BrandRequest;
import com.microcommerce.product.domain.dto.BrandResponse;
import com.microcommerce.product.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> findById(@PathVariable String id) {
        BrandResponse brandResponse = brandService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(brandResponse);
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> findAllPaginated(@RequestParam("page") Integer page) {
        List<BrandResponse> brandResponse = brandService.findAllPaginated(page);
        return ResponseEntity.status(HttpStatus.OK).body(brandResponse);
    }

    @PostMapping
    public ResponseEntity<BrandResponse> insert(@Valid @RequestBody BrandRequest brandRequest) {
        BrandResponse brandResponse = brandService.insert(brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(brandResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> insert(
            @PathVariable String id,
            @Valid @RequestBody BrandRequest brandRequest
    ) {
        BrandResponse brandResponse = brandService.update(id, brandRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(brandResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean result = brandService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
