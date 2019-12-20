package com.conduent.claim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Paramesh
 * @version: initial
 * @Since:
 * 
 * Application Runner is an interface used to execute the code after the Spring Boot application started.
 */
@SpringBootApplication
public class ClaimApp implements ApplicationRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimApp.class);
	
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

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		System.out.println("Hello world from application runner");
	}	
}
