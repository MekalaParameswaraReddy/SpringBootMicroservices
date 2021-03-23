package com.conduent.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.conduent.provider.config.YAMLConfig;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@SpringBootApplication
public class ProviderApp implements CommandLineRunner {
	
	@Autowired
	private YAMLConfig yAMLConfig;
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		SpringApplication app = new SpringApplication(ProviderApp.class);
        app.run();
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(yAMLConfig.getEnvironment());
		System.out.println(yAMLConfig.getName());
		System.out.println(yAMLConfig.getServers());
		System.out.println(yAMLConfig.isEnabled());
		
	}

}
