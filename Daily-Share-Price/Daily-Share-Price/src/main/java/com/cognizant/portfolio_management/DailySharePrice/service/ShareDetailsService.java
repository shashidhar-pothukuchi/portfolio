package com.cognizant.portfolio_management.DailySharePrice.service;

import java.util.ArrayList;
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

	public List<Double> getSharebyId(List<String> shareId) {
		List<Double> shareList = new ArrayList<>();
		for(String id:shareId) {
			shareList.add( repository.findByShareId(id).getShareValue());
		}
		return shareList;
	}

}
