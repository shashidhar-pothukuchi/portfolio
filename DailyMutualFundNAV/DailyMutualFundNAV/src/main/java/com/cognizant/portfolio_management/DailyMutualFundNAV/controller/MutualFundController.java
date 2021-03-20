package com.cognizant.portfolio_management.DailyMutualFundNAV.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;
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
	

	@GetMapping("/dailyMutualFundNav/name/{mutualFundName}")
	public MutualFund getDailyMutualFundNav(@PathVariable String mutualFundName) throws MutualFundNotFoundException{
		return service.getMutualFundByName(mutualFundName);
	}
	
	@GetMapping("/dailyMutualFundNav/{mutualFundId}")
	public List<Double> getDailyMutualFundNavById(@PathVariable(value="mutualFundId") List<String> mutualFundIdList) throws MutualFundNotFoundException{
			return service.getMutualFundById(mutualFundIdList);
	}
}
