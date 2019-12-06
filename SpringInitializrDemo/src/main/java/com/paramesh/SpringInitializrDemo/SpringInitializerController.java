package com.paramesh.SpringInitializrDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@RestController
public class SpringInitializerController {
		
	@RequestMapping("/springInitializer")
	public String sayHello(){
		return "This intialized from Spring Initializer ... !!!!";
	}	
}
