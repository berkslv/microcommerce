package com.microcommerce.product.service;


import com.microcommerce.product.domain.dto.ProductRequest;
import com.microcommerce.product.domain.dto.ProductResponse;
import com.microcommerce.product.domain.entity.Product;
import com.microcommerce.product.exception.ApiException;
import com.microcommerce.product.exception.Result;
import com.microcommerce.product.mapper.ProductMapper;
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
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public Boolean isInStock(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ApiException("Product not found with id: {0}", id);
        }

        Product product = optionalProduct.get();

        return product.getStock() > 0;
    }

    public ProductResponse findById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ApiException("Product not found with id: {0}", id);
        }

        log.info("Product found with id: {0}", id);
        return mapper.mapProductToProductResponse(optionalProduct.get());
    }

    public List<ProductResponse> findAllPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page, 20);
        List<Product> products = productRepository.findAll(pageable).toList();

        log.info("Product list found");
        return mapper.mapProductsToProductResponses(products);
    }

    public ProductResponse insert(ProductRequest productRequest) {
        Product product = mapper.mapProductRequestToProduct(productRequest);

        log.info("Product inserted with name: {0}", productRequest.getName());
        return mapper.mapProductToProductResponse(productRepository.save(product));
    }

    public ProductResponse update(String id, ProductRequest productRequest) {
        if (!productRepository.existsById(id)) {
            throw new ApiException("Product not found with id: {0}", id);
        }

        Product product = mapper.mapProductRequestToProduct(productRequest);
        product.setId(id);

        log.info("Product updated with id: {0}", id);
        return mapper.mapProductToProductResponse(productRepository.save(product));
    }

    public boolean delete(String id) {
        if (!productRepository.existsById(id)) {
            throw new ApiException("Product not found with id: {0}", id);
        }

        productRepository.deleteById(id);
        log.info("Product deleted with id: {0}", id);
        return true;
    }
}
