package com.microcommerce.basket.mapper;

import com.microcommerce.basket.domain.dto.ProductRequest;
import com.microcommerce.basket.domain.dto.ProductResponse;
import com.microcommerce.basket.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public List<ProductResponse> mapProductsToProductResponses(List<Product> products) {
        return products
                .stream()
                .map(this::mapProductToProductResponse)
                .toList();
    }

    public Product mapProductRequestToProduct(ProductRequest productRequest) {
        return Product
                .builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .imageUrl(productRequest.getImageUrl())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
    }

}
