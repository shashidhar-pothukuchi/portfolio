package com.cognizant.portfolio_management.DailySharePrice.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.portfolio_management.DailySharePrice.model.ShareDetails;

public interface ShareRepository extends JpaRepository<ShareDetails,String>{
	
	public List<ShareDetails> findAll();
	
	public ShareDetails findByShareName(String shareName);

	public ShareDetails findByShareId(String shareId);
 
}
