package com.currency.transaction.Currency.Transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients("com.currency.transaction.Currency.Transaction")
@EnableDiscoveryClient
public class CurrencyTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyTransactionApplication.class, args);
	}
}
