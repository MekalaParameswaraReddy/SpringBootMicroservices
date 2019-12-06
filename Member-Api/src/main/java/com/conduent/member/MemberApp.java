package com.conduent.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Paramesh
 * @version:;;
 * @Since:
 */
@SpringBootApplication
public class MemberApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("member API is started.....!");
		SpringApplication.run(MemberApp.class, args);
	}

}
