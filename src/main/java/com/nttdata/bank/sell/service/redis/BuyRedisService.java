package com.nttdata.bank.sell.service.redis;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.nttdata.bank.sell.model.Buy;

@Service
public class BuyRedisService {
	
	@Autowired
	private ResponseBuyRedisService responseBuyRedisService;
	
	private static final String KEY = "Buys";

    private RedisTemplate<String, Buy> redisTemplate;
    private HashOperations hashOperations;

    public BuyRedisService(RedisTemplate<String, Buy> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
    	hashOperations = redisTemplate.opsForHash();
    }
    
    public void save(Buy buy) {
    	hashOperations.put(KEY, UUID.randomUUID().toString(), buy);
    }
    
    public Map<String, Buy> findAll(){
    	return hashOperations.entries(KEY);
    }
    
    public Buy findById(String id) {
    	Buy buy = new Buy();
    	buy = (Buy) hashOperations.get(KEY, id);
    	responseBuyRedisService.save(buy);
        return buy;
    }
    
}