package com.conduent.provider.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.conduent.provider.bean.Provider;
import com.conduent.provider.bean.ProviderResposeVo;
import com.conduent.provider.constants.ProviderConstants;
import com.conduent.provider.dao.ProviderDAO;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@Service
public class ProviderService {
	
	@Autowired
	@Qualifier("providerDAOImpl")
	ProviderDAO providerDAO;
	
	@Autowired
	ProviderConstants providerConstants;

	List<Provider>  list = new ArrayList<> (Arrays.asList(
			new Provider("1234", "provider1", "ORP"),
			new Provider("1235", "provider2", "Render"),
			new Provider("1236", "provider3", "Billing"),
			new Provider("1237", "provider4", "non - Billing")));
	
	public ResponseEntity<ProviderResposeVo> getProviders(){		
		List list =  providerDAO.getProviders();
		ProviderResposeVo providerResposeVo = new ProviderResposeVo();
		if(list == null|| list.size()==0) {
			providerResposeVo.setStatus(providerConstants.failMsg);
			providerResposeVo.setList(list);
			return new  ResponseEntity<ProviderResposeVo>(providerResposeVo, HttpStatus.BAD_REQUEST);
		} else {
			providerResposeVo.setStatus(providerConstants.successMsg);
			providerResposeVo.setList(list);
			return new ResponseEntity<ProviderResposeVo>(providerResposeVo, HttpStatus.OK);
		}
	}
	
	public Provider getProvider(String id){
		return list.stream().filter(x->x.getId().equals(id)).findFirst().get();
	}
	
	public void deleteProvider(String type){
		list.removeIf(x -> x.getType().equalsIgnoreCase(type));
		System.out.println(" deleted ----- " + type);
	}
	
	public void addProvider(Provider provider){
		list.add(provider);
		System.out.println("Provider is added ----- Through POST request" );
	}
	
	public void addProviderByPutMode(Provider provider){
		list.add(provider);
		System.out.println("Provider is added ----- Through PUT request" );
	}
	
	public Provider getProviderByIdAndName(String id, String name) {
		
		System.out.println(id + " " + name);
		boolean flag = list.stream().anyMatch(x -> x.getId().equals(id));
		if (flag) {
			return list
					.stream()
					.filter(x -> x.getId().equals(id) && x.getName().equals(name)).findFirst().get();
		} else {
			// return new Provider("dummy", "dummy", "dummy");
			return new Provider();
		}
	}
}
