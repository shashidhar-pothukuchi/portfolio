package com.cognizant.calculateNetworth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.AuthResponse;
import com.cognizant.calculateNetworth.reposotory.AssetRepository;
import com.cognizant.calculateNetworth.controller.AuthClient;
@Service
public class SellAssetService {
	
	@Autowired
	private AssetRepository repository;
	
	@Autowired
	private AuthClient authClient;
	
	public void deleteAssetByAssetId(int portfolioId,String assetId,String type) {
		Asset a = repository.findByPortfolioidAndAssetidAndType(portfolioId,assetId, type);
		repository.delete(a);
	}
	
	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}

}
