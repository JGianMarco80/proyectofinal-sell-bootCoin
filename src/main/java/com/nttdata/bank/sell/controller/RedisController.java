package com.nttdata.bank.sell.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bank.sell.model.Buy;
import com.nttdata.bank.sell.model.ResponseBuy;
import com.nttdata.bank.sell.service.redis.BuyRedisService;
import com.nttdata.bank.sell.service.redis.ResponseBuyRedisService;

@RestController
public class RedisController {

	@Autowired
	private BuyRedisService buyRedisService;
	
	@Autowired
	private ResponseBuyRedisService responseBuyRedisService;
	
	@GetMapping("/buy")
	public Map<String, Buy> findAll(){
		return buyRedisService.findAll();
	}
	
	@GetMapping("/buy/{id}")
	public Buy findById(@PathVariable String id){
		return buyRedisService.findById(id);
	}
	
	@GetMapping("/responseBuy")
	public Map<String, ResponseBuy> findAllResponseBuy(){
		return responseBuyRedisService.findAll();
	}
	
}