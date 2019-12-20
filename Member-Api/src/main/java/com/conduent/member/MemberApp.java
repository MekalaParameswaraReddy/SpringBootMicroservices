package com.conduent.member;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Paramesh
 * @version:;;
 * @Since:
 */
@SpringBootApplication
public class MemberApp implements CommandLineRunner{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("member API is started.....!");
		SpringApplication.run(MemberApp.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {	
		System.out.println("Hello world from Command Line Runner");
	}

}
