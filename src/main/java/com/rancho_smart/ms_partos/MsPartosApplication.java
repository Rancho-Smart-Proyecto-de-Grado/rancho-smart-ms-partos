package com.rancho_smart.ms_partos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPartosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPartosApplication.class, args);
	}

}
