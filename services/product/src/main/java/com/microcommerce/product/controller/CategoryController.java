package com.microcommerce.product.controller;

import com.microcommerce.product.domain.dto.CategoryRequest;
import com.microcommerce.product.domain.dto.CategoryResponse;
import com.microcommerce.product.domain.dto.ProductRequest;
import com.microcommerce.product.domain.dto.ProductResponse;
import com.microcommerce.product.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable String id) {
        CategoryResponse categoryResponse = categoryService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllPaginated(@RequestParam("page") Integer page) {
        List<CategoryResponse> categoryResponse = categoryService.findAllPaginated(page);
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> insert(@Valid @RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.insert(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> insert(
            @PathVariable String id,
            @Valid @RequestBody CategoryRequest categoryRequest
    ) {
        CategoryResponse categoryResponse = categoryService.update(id, categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        boolean result = categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
