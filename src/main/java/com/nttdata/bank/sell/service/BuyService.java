package com.nttdata.bank.sell.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.nttdata.bank.sell.model.Buy;
import com.nttdata.bank.sell.service.redis.BuyRedisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BuyService {
	
	@Autowired
	private BuyRedisService buyRedisService;
	
	/*@Bean
	Consumer<Buy> buyBootCoin(){
		return buy -> {
			log.info("buy: " + buy);
		};
	}*/
	
	@Bean
	Consumer<Buy> buyBootCoin(){
		Buy buyRedis = new Buy();
		return buy -> {
			buyRedis.setAmount(buy.getAmount());
			buyRedis.setMobile(buy.getMobile());
			buyRedis.setPayMode(buy.getPayMode());
			buyRedisService.save(buyRedis);
			log.info("buy: " + buy);
		};
	}
	
}
