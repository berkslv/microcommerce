package com.microcommerce.product.mapper;

import com.microcommerce.product.domain.dto.*;
import com.microcommerce.product.domain.entity.Brand;
import com.microcommerce.product.domain.entity.Category;
import com.microcommerce.product.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrandMapper {

    public BrandResponse mapBrandToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }

    public List<BrandResponse> mapBrandsToBrandResponses(List<Brand> brands) {
        return brands
                .stream()
                .map(brand -> BrandResponse.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .build()
                ).toList();
    }

    public Brand mapBrandRequestToBrand(BrandRequest brandRequest) {
        return Brand.builder()
                .name(brandRequest.getName())
                .build();
    }

}
