package com.microcommerce.product.service;


import com.microcommerce.product.domain.dto.BrandRequest;
import com.microcommerce.product.domain.dto.BrandResponse;
import com.microcommerce.product.domain.entity.Brand;
import com.microcommerce.product.exception.ApiException;
import com.microcommerce.product.mapper.BrandMapper;
import com.microcommerce.product.repository.BrandRepository;
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
public class BrandService {

    private final BrandRepository repository;

    private final BrandMapper mapper;

    public BrandResponse findById(String id) {
        Optional<Brand> optionalBrand = repository.findById(id);

        if (optionalBrand.isEmpty()) {
            throw new ApiException("Brand not found with id: {0}", id);
        }

        log.info("Brand found with id: {0}", id);
        return mapper.mapBrandToBrandResponse(optionalBrand.get());
    }

    public List<BrandResponse> findAllPaginated(Integer page) {
        Pageable pageable = PageRequest.of(page, 20);
        List<Brand> brands = repository.findAll(pageable).toList();

        log.info("Brand list found");
        return mapper.mapBrandsToBrandResponses(brands);
    }

    public BrandResponse insert(BrandRequest brandRequest) {
        Brand brand = mapper.mapBrandRequestToBrand(brandRequest);

        log.info("Brand inserted with name: {0}", brandRequest.getName());
        return mapper.mapBrandToBrandResponse(repository.save(brand));
    }

    public BrandResponse update(String id, BrandRequest brandRequest) {
        if (!repository.existsById(id)) {
            throw new ApiException("Product not found with id: {0}", id);
        }

        Brand brand = mapper.mapBrandRequestToBrand(brandRequest);
        brand.setId(id);

        log.info("Brand updated with id: {0}", id);
        return mapper.mapBrandToBrandResponse(repository.save(brand));
    }

    public boolean delete(String id) {
        if (!repository.existsById(id)) {
            throw new ApiException("Brand not found with id: {0}", id);
        }

        repository.deleteById(id);

        log.info("Brand deleted with id: {0}", id);
        return true;
    }

}
