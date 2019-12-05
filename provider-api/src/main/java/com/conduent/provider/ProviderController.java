package com.conduent.provider;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conduent.provider.bean.Provider;
import com.conduent.provider.dao.ProviderDAO;
import com.conduent.provider.dao.ProviderDAOImpl;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@RestController
public class ProviderController {

	@Autowired
	private ProviderService providerService;

	@RequestMapping("/hello")
	public String getName() {
		return "Prameswara";
	}

	@RequestMapping("/providers")
	public List<Provider> getProviders() {
		//Below two lines are actual implimetantion.
		ProviderDAO providerDAO = new ProviderDAOImpl();
		providerDAO.getProviders();
		
		return providerService.getProviders();
	}

	@RequestMapping("/getProvider/{foo}")
	public Provider getProvider(@PathVariable("foo") String id) {
		return providerService.getProvider(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteProvider/{proType}")
	public void deleteProvider(@PathVariable("proType") String type) {
		providerService.deleteProvider(type);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addProvider")
	public void addProvider(@RequestBody Provider provider) {
		providerService.addProvider(provider);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/addProviderByPutMode")
	public void addProviderByPutMode(@RequestBody Provider provider) {
		providerService.addProviderByPutMode(provider);
	}

	// URL to access : http://localhost:2022/getProviderByIdAndName/123/param
	@RequestMapping("/getProviderByIdAndName/{firstParam}/{secondParam}")
	public Provider getProviderByIdAndName(@PathVariable("firstParam") String id, @PathVariable("secondParam") String name) {
		return providerService.getProviderByIdAndName(id, name);
	}

	// URL to access : http://localhost:2022/getProviderByIdAndName1/123/param
	@RequestMapping("/getProviderByIdAndName1/{firstParam}/{secondParam}/{thirdParam}/{fourthParam}")
	public void getProviderByIdAndName1(@PathVariable Map<String, String> params) {
		params.forEach((k, v) -> System.out.println(k + " = " + v));
	}

	// URL to access : http://localhost:2022/getProviderByIdAndName2/1234/Alex/Master degree/U.S.A
	@RequestMapping("/getProviderByIdAndName2/{firstParam}/{secondParam}/{thirdParam}/{fourthParam}")
	public void getProviderByIdAndName2(@PathVariable Map<String, String> params) {
		String firstName = params.get("firstParam");
		String secondName = params.get("secondParam");
		String thirdName = params.get("thirdParam");
		String fourthName = params.get("fourthParam");
		System.out.println(firstName + ", " + secondName + ", " + thirdName + ", " + fourthName);
	}
	
	
}
