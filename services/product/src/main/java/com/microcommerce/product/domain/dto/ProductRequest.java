package com.microcommerce.product.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    @NotEmpty
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotEmpty
    @NotNull
    @Size(min = 1)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    @NotEmpty
    private String categoryId;

    @NotNull
    @NotEmpty
    private String brandId;

    @NotNull
    private Long stock;
}
