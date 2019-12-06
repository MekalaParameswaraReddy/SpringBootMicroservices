package com.conudent.rulesmgmt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulesMgmtController {
	
	@RequestMapping("/getRules")
	public String getRules(){
		return "There are so many ruels in our application";
	}
}
