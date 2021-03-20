package com.cognizant.calculateNetworth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.MutualFundDetails;
import com.cognizant.calculateNetworth.model.SellObject;
import com.cognizant.calculateNetworth.model.SellObjectMap;
import com.cognizant.calculateNetworth.model.StockDetails;
import com.cognizant.calculateNetworth.service.AssetService;
import com.cognizant.calculateNetworth.service.SellAssetService;

@RestController
@RequestMapping("/NetWorth")
public class StocksContoller {

	@Autowired
	private ShareDetailsFiegnProxy proxy;
	
	@Autowired
	private MutualFundDetailsFeignProxy mutualFundProxy;
	
	@Autowired
	private AssetService assetservice;
	
	@Autowired
	private SellAssetService sellService;
	
	@GetMapping("/calculateNetworth/{id}")
	public double getAsset(@PathVariable(value="id") int id){
		
		double netWorth = 0.0; 
		List<String> stockAssetList = new ArrayList<>();
		List<String> mutualFundAssetList = new ArrayList<>();
		List<Double> stockValueList = new ArrayList<>();
		List<Double> mutualFundValueList =new ArrayList<>();
		List<Asset> assets = assetservice.getAllAssetForPortfolio(id);
		//List<StockDetails> shareslist = proxy.findAll();
		for(Asset a:assets) {
			if(a.getType().equals("Share")) {
				stockAssetList.add(a.getAssetid());
			}else {
				mutualFundAssetList.add(a.getAssetid());
			}
		}
		if(!stockAssetList.isEmpty()) {
			stockValueList =proxy.finddailyShareById(stockAssetList);
		}
		if(!mutualFundAssetList.isEmpty()) {
			mutualFundValueList =mutualFundProxy.getMutualDetailsById(mutualFundAssetList);
		}
		int stockCounter=0,mfCounter=0;
		for(Asset a:assets) {
			if(a.getType().equals("Share")) {
				netWorth+=a.getUnits()*stockValueList.get(stockCounter);
				stockCounter++;
			}else {
				netWorth+=a.getUnits()*mutualFundValueList.get(mfCounter);
				mfCounter++;
			}
		}
		return netWorth;
		
	}
	
//	@PostMapping("/SellAseets/{portfolioId}/{assetId}/{assetType}")
//	public double calculateBalancePostSell(@PathVariable(value="portfolioId") int portfolioId,@PathVariable(value="assetId") String assetId,@PathVariable(value="assetType") String assetType) {
//		sellService.deleteAssetByAssetId(portfolioId,assetId, assetType);
//		return getAsset(portfolioId);
//	}
	
	@PostMapping("/SellAssets")
	public double calculateBalancePostSell(@RequestBody SellObject sell) {
//		SellObject sell =(SellObject) obj; 
		
		List<String> stockIdList=sell.getStockIdList();
		List<String> mfIdList=sell.getMfAssetList();
		if(!stockIdList.isEmpty()) {
			sellService.deleteStockAsset(sell.getPid(),stockIdList);
		}
		if(!mfIdList.isEmpty()) {
			sellService.deleteMutualFundAsset(sell.getPid(),mfIdList);
		}
		return getAsset(sell.getPid());
	}
	
	@GetMapping("/shares")
	public List<Asset> getAllStocks(){
		List<Asset> stockList = new ArrayList<>();
		List<StockDetails> shareslist = proxy.findAll();
		for(StockDetails s:shareslist)
		{
			stockList.add(new Asset(10,s.getShareId(),1,"share",10));
		}
		return stockList;
	}
	
	@GetMapping("/pershare/{shareName}")
	public StockDetails getStcokName(@PathVariable(value="shareName") String shareName) {
		return proxy.finddailyShareByName(shareName);
	}
	
//	@GetMapping("/pershareId/{shareId}")
//	public StockDetails getStcokById(@PathVariable(value="shareId") String shareId) {
//		return proxy.finddailyShareById(shareId);
//	}
	
	@GetMapping("/mutualfunds")
	public List<MutualFundDetails> getAllMutualFunds(){
		return mutualFundProxy.getAllMututalFunds();
	}
//	
//	@GetMapping("/dailyMutualFundNav/{mutualFundId}")
//	public MutualFundDetails getMutualDetails(@PathVariable(value="mutualFundId") String mutualFundId) {
//		return mutualFundProxy.getMutualDetailsById(mutualFundId);
//	}
//	
	
//	
//	@PostMapping("/SellAssets/PerStock")
//	public double calculateBalancePostSellPerStock(@RequestBody SellObjectMap sell) {
////		SellObject sell =(SellObject) obj; 
//		
//		Map<String,Integer> stockIdList=sell.getStockIdList();
//		Map<String,Integer> mfIdList=sell.getMfAssetList();
//		if(!stockIdList.isEmpty()) {
//			sellService.deleteStockAsset(sell.getPid(),stockIdList);
//		}
//		if(!mfIdList.isEmpty()) {
//			sellService.deleteMutualFundAsset(sell.getPid(),mfIdList);
//		}
//		return getAsset(sell.getPid());
//	}
//	
}
