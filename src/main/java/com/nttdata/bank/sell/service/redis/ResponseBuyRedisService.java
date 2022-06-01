package com.nttdata.bank.sell.service.redis;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.nttdata.bank.sell.model.Buy;
import com.nttdata.bank.sell.model.ResponseBuy;

@Service
public class ResponseBuyRedisService {
	
	private static final String KEY = "ResponseBuys";
	
	private RedisTemplate<String, ResponseBuy> redisTemplate;
    private HashOperations hashOperations;

    public ResponseBuyRedisService(RedisTemplate<String, ResponseBuy> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
    	hashOperations = redisTemplate.opsForHash();
    }
    
    public void save(Buy buy) {
    	ResponseBuy responseBuy = new ResponseBuy();
    	responseBuy.setAmount(buy.getAmount());
    	responseBuy.setMobile(buy.getMobile());
    	responseBuy.setPayMode(buy.getPayMode());
    	responseBuy.setTransactionNumber(UUID.randomUUID().toString());
    	hashOperations.put(KEY, UUID.randomUUID().toString(), responseBuy);
    }
    
    public Map<String, ResponseBuy> findAll(){
    	return hashOperations.entries(KEY);
    }

}