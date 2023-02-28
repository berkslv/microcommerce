package com.microcommerce.basket.repository;

import com.microcommerce.basket.domain.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BasketRepository {
    public static final String HASH_KEY = "Basket";
    @Autowired
    private RedisTemplate template;

    public Basket save(Basket basket){
        template.opsForHash().put(HASH_KEY, basket.getId(), basket);
        return basket;
    }

    public List<Basket> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Basket findById(String id){
        return (Basket) template.opsForHash().get(HASH_KEY,id);
    }


    public Boolean delete(String id){
        template.opsForHash().delete(HASH_KEY,id);
        return true;
    }
}
