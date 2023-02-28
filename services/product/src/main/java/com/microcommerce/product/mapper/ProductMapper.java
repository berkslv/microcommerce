package com.microcommerce.product.mapper;

import com.microcommerce.product.domain.dto.ProductRequest;
import com.microcommerce.product.domain.dto.ProductResponse;
import com.microcommerce.product.domain.entity.Product;
import com.microcommerce.product.exception.ApiException;
import com.microcommerce.product.repository.BrandRepository;
import com.microcommerce.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .stock(product.getStock())
                .category(product.getCategory())
                .brand(product.getBrand())
                .build();
    }

    public List<ProductResponse> mapProductsToProductResponses(List<Product> products) {
        return products
                .stream()
                .map(product -> ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .imageUrl(product.getImageUrl())
                    .stock(product.getStock())
                    .category(product.getCategory())
                    .brand(product.getBrand())
                    .build()
                ).toList();
    }

    public Product mapProductRequestToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .stock(productRequest.getStock())
                .category(categoryRepository.findById(productRequest.getCategoryId()).orElseThrow(() ->
                    new ApiException("Category cannot find with given id.")
                ))
                .brand(brandRepository.findById(productRequest.getBrandId()).orElseThrow(() ->
                    new ApiException("Brand cannot find with given id.")
                ))
                .build();
    }


}
