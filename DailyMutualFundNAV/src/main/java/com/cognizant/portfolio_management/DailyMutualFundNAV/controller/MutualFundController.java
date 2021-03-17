package com.cognizant.portfolio_management.DailyMutualFundNAV.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.service.MutualFundService;

@RestController
public class MutualFundController {
	
	
	@Autowired
	private MutualFundService service;
	
	@GetMapping("/dailyAllMutualFundNav")
	public List<MutualFund> getAllMutualFund(){
		return service.getAllMutualFund();
	}
	

	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFund getDailyMutualFundNav(@PathVariable String mutualFundName){
		return service.getMutualFundByName(mutualFundName);
	}
}
