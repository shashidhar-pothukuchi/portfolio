package com.cognizant.portfolio_management.DailySharePrice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.portfolio_management.DailySharePrice.model.ShareDetails;
import com.cognizant.portfolio_management.DailySharePrice.respository.ShareRepository;
@Service
public class ShareDetailsService {
	
	
	@Autowired
	private ShareRepository repository;
	
	@Transactional
	public List<ShareDetails> getAllShares(){
		return repository.findAll();
	}
	
	@Transactional
	public ShareDetails getSharebyName(String shareName){
		return repository.findByShareName(shareName);
	}

	public ShareDetails getSharebyId(String shareId) {
		return repository.findByShareId(shareId);
	}

}
