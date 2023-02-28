package com.microcommerce.basket.service;

import com.microcommerce.basket.domain.dto.BasketRequest;
import com.microcommerce.basket.domain.dto.BasketResponse;
import com.microcommerce.basket.domain.entity.Basket;
import com.microcommerce.basket.exception.ApiException;
import com.microcommerce.basket.mapper.BasketMapper;
import com.microcommerce.basket.repository.BasketRepository;
import com.microcommerce.basket.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final SecurityUtil securityUtil;
    private final BasketMapper basketMapper;

    public BasketResponse find() {
        String username = securityUtil.getUsername();
        Basket basket = basketRepository.findById(username);

        if (basket == null) {
            throw new ApiException("Basket not found with username: {0}", username);
        }

        log.info("Basket found with username: " + username);
        return basketMapper.mapBasketToBasketResponse(basket);
    }

    public BasketResponse save(BasketRequest basketRequest) {
        Basket basket = basketMapper.mapBasketRequestToBasket(basketRequest);
        String username = securityUtil.getUsername();
        basket.setId(username);

        Basket createdBasket = basketRepository.save(basket);

        log.info("Basket inserted with username: " + createdBasket.getId());
        return basketMapper.mapBasketToBasketResponse(createdBasket);
    }

    public boolean delete() {
        String username = securityUtil.getUsername();

        basketRepository.delete(username);
        log.info("Basket deleted with username: " + username);
        return true;
    }

}
