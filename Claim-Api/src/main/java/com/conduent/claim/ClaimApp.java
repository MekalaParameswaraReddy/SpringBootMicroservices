package com.conduent.claim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Paramesh
 * @version: initial
 * @Since:
 */
@SpringBootApplication
public class ClaimApp {
	
	//@Bean : is like producer, it will create the object and keep it ready for other resource to use it.
	@Bean
	public RestTemplate getRestTemplate(){
		System.out.println(" object is created ....! ");
		return new RestTemplate();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClaimApp.class, args);
	}
}
