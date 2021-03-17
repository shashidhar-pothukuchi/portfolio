package com.cognizant.portfolio_management.DailyMutualFundNAV.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;

public interface MutualFundRepository extends JpaRepository<MutualFund,String>{
	
	public List<MutualFund> findAll();
	
	public MutualFund findByMutualFundName(String mutualFundName);
 
}
