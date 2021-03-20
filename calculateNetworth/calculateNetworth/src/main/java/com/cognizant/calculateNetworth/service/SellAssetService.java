package com.cognizant.calculateNetworth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.reposotory.AssetRepository;
@Service
public class SellAssetService {
	
	@Autowired
	private AssetRepository repository;
	
	public void deleteStockAsset(int portfolioId,List<String> idList) {
		for(String id:idList) {
		Asset a = repository.findByPortfolioidAndAssetidAndType(portfolioId,id,"Share");
		repository.delete(a);
		}
	}
	
	public void deleteMutualFundAsset(int portfolioId,List<String> idList) {
		for(String id:idList) {
		Asset a = repository.findByPortfolioidAndAssetidAndType(portfolioId,id,"MF");
		repository.delete(a);
		}
	}

}
