package com.cognizant.portfolio_management.DailySharePrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.portfolio_management.DailySharePrice.model.ShareDetails;
import com.cognizant.portfolio_management.DailySharePrice.service.ShareDetailsService;

@RestController
public class ShareDetailsController {
	
	
	@Autowired
	private ShareDetailsService service;
	
	@GetMapping("/dailyAllSharePrice")
	public List<ShareDetails> getAllDailySharePrice(){
		return service.getAllShares();
	}
	

	@GetMapping("/dailySharePrice/name/{shareName}")
	public ShareDetails getDailySharePrice(@PathVariable String shareName){
		return service.getSharebyName(shareName);
	}
	
	@GetMapping("/dailySharePrice/{shareId}")
	public ShareDetails getDailySharePriceByID(@PathVariable String shareId){
		return service.getSharebyId(shareId);
	}
	
}
