package com.microcommerce.product.service;

import com.microcommerce.product.domain.dto.CategoryRequest;
import com.microcommerce.product.domain.dto.CategoryResponse;
import com.microcommerce.product.domain.dto.ProductRequest;
import com.microcommerce.product.domain.dto.ProductResponse;
import com.microcommerce.product.domain.entity.Category;
import com.microcommerce.product.domain.entity.Product;
import com.microcommerce.product.exception.ApiException;
import com.microcommerce.product.mapper.CategoryMapper;
import com.microcommerce.product.mapper.ProductMapper;
import com.microcommerce.product.repository.CategoryRepository;
import com.microcommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository repository;

    private final CategoryMapper mapper;

    public CategoryResponse findById(String id) {
        Optional<Category> optionalCategory = repository.findById(id);

        if (optionalCategory.isEmpty()) {
            throw new ApiException("Category not found with id: {0}", id);
        }

        log.info("Category found with id: {0}", id);
        return mapper.mapCategoryToCategoryResponse(optionalCategory.get());
    }

    public List<CategoryResponse> findAllPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page, 20);
        List<Category> categories = repository.findAll(pageable).toList();

        log.info("Category list found");
        return mapper.mapCategoriesToCategoryResponses(categories);
    }

    public CategoryResponse insert(CategoryRequest categoryRequest) {
        Category category = mapper.mapCategoryRequestToCategory(categoryRequest);

        log.info("Category inserted with name: {0}", categoryRequest.getName());
        return mapper.mapCategoryToCategoryResponse(repository.save(category));
    }

    public CategoryResponse update(String id, CategoryRequest categoryRequest) {
        if (!repository.existsById(id)) {
            throw new ApiException("Product not found with id: {0}", id);
        }

        Category category = mapper.mapCategoryRequestToCategory(categoryRequest);
        category.setId(id);

        log.info("Category updated with id: {0}", id);
        return mapper.mapCategoryToCategoryResponse(repository.save(category));
    }

    public boolean delete(String id) {
        if (!repository.existsById(id)) {
            throw new ApiException("Category not found with id: {0}", id);
        }

        repository.deleteById(id);

        log.info("Category deleted with id: {0}", id);
        return true;
    }
}
