package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.calculateNetworth.model.StockDetails;

@FeignClient(name="ShareDetailsService",url="localhost:8090")
public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/dailyAllSharePrice")
	public List<StockDetails> findAll();
	
	@GetMapping("/dailySharePrice/name/{shareName}")
	public StockDetails finddailyShareByName(@PathVariable(value="shareName") String shareName);
	
	@GetMapping("/dailySharePrice/{shareId}")
	public StockDetails finddailyShareById(@PathVariable(value="shareId")String shareId);
	

}
