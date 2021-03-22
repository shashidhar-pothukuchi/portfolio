package com.cognizant.portfolio_management.DailySharePrice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DailySharePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailySharePriceApplication.class, args);
	}

}
