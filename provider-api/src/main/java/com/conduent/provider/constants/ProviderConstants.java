package com.conduent.provider.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:message.properties")
public class ProviderConstants {
	
	@Value("${success}")
	public String successMsg;
	
	@Value("${fail}")
	public String failMsg;
}
