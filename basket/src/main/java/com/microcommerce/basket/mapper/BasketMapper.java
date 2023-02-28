package com.microcommerce.basket.mapper;

import com.microcommerce.basket.domain.dto.ProductResponse;
import com.microcommerce.basket.domain.dto.BasketRequest;
import com.microcommerce.basket.domain.dto.BasketResponse;
import com.microcommerce.basket.domain.entity.Basket;
import com.microcommerce.basket.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BasketMapper {

    private final ProductMapper productMapper;

    public BasketResponse mapBasketToBasketResponse(Basket basket) {
        List<ProductResponse> productResponses = basket
                .getProducts()
                .stream()
                .map(productMapper::mapProductToProductResponse)
                .toList();

        return BasketResponse
                .builder()
                .id(basket.getId())
                .products(productResponses)
                .build();
    }

    public List<BasketResponse> mapBasketsToBasketResponses(List<Basket> baskets) {
        return baskets
                .stream()
                .map(this::mapBasketToBasketResponse)
                .toList();
    }

    public Basket mapBasketRequestToBasket(BasketRequest basketRequest) {
        List<Product> products = basketRequest
                .getProducts()
                .stream()
                .map(productMapper::mapProductRequestToProduct)
                .toList();

        return Basket
                .builder()
                .products(products)
                .build();
    }

}
