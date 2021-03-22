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
	
	public List<Double> getSharebyIdList(List<String> shareId) {
		List<Double> shareValueList = new ArrayList<>();
		List<ShareDetails> shareList=  repository.findByShareId(shareId);
		for(ShareDetails s:shareList) {
			shareValueList.add( s.getShareValue());
		}
		return shareValueList;
	}
	

}
