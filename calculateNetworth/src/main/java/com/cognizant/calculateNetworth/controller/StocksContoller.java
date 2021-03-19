package com.cognizant.calculateNetworth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.MutualFundDetails;
import com.cognizant.calculateNetworth.model.StockDetails;
import com.cognizant.calculateNetworth.service.AssetService;

@RestController
public class StocksContoller {

	@Autowired
	private ShareDetailsFiegnProxy proxy;
	
	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;
	
	@Autowired
	private AssetService assetservice;
	
	@GetMapping("/GetNetWorth/{id}")
	public double getAsset(@PathVariable(value="id") int id){
		
		double netWorth = 0.0; 
		
		List<Asset> assets = assetservice.getAllAssetForPortfolio(id);
		//List<StockDetails> shareslist = proxy.findAll();
		for(Asset i:assets) {
			if(i.getType().equals("Share")) {
				StockDetails s = proxy.finddailyShareById(i.getAssetid());
				netWorth+=(s.getShareValue()*i.getUnits());
			}else {
				MutualFundDetails m = mutualFundProxy.getMutualDetailsById(i.getAssetid());
				netWorth+=(m.getMutualFundValue() *i.getUnits());
			}
		}
		return netWorth;
		
	}
	
	@GetMapping("/GetNetWorth/shares")
	public List<Asset> getAllStocks(){
		List<Asset> stockList = new ArrayList<>();
		List<StockDetails> shareslist = proxy.findAll();
		for(StockDetails s:shareslist)
		{
			stockList.add(new Asset(10,s.getShareId(),1,"share",10));
		}
		return stockList;
	}
	
	@GetMapping("/GetNetWorth/pershare/{shareName}")
	public StockDetails getStcokName(@PathVariable(value="shareName") String shareName) {
		return proxy.finddailyShareByName(shareName);
	}
	
	@GetMapping("/GetNetWoth/mutualfunds")
	public List<MutualFundDetails> getAllMutualFunds(){
		return mutualFundProxy.getAllMututalFunds();
	}
	
	@GetMapping("/dailyMutualFundNav/{mutualFundName}")
	public MutualFundDetails getMutualDetails(@PathVariable(value="mutualFundName") String mutualFundName) {
		return mutualFundProxy.getMutualDetails(mutualFundName);
	}
	
}
