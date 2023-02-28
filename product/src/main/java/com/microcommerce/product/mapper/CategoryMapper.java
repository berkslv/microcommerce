package com.microcommerce.product.mapper;

import com.microcommerce.product.domain.dto.CategoryRequest;
import com.microcommerce.product.domain.dto.CategoryResponse;
import com.microcommerce.product.domain.dto.ProductRequest;
import com.microcommerce.product.domain.entity.Category;
import com.microcommerce.product.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    public CategoryResponse mapCategoryToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public List<CategoryResponse> mapCategoriesToCategoryResponses(List<Category> categories) {
        return categories
                .stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .description(category.getDescription())
                        .build()
                ).toList();
    }

    public Category mapCategoryRequestToCategory(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
    }

}
