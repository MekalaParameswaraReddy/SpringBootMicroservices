package com.conduent.claim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.conduent.claim.bean.Claim;
import com.conduent.claim.bean.Member;
import com.conduent.claim.bean.Provider;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@Service
public class CliamService {
	
	// RestTemplate object created only once, at the time of loding the ClaimApp
	/* RestTemplate restTemplate = new RestTemplate(); for each request one new object will crate. */
	@Autowired
	public  RestTemplate restTemplate;
	
	List<Claim> list = new ArrayList<>(Arrays.asList(
			new Claim("123456789001", "dental" , "suspense"),
			new Claim("123456789002", "dental" , "denide"),
			new Claim("123456789003", "dental" , "paid"),
			new Claim("123456789004", "dummy" , "dummy")));
	
	public List<Claim> getClaims(){
		return list;
	}
	
	public Claim getClaimByTcn(String tcn){
		return list.stream().filter(x -> x.getTcn().equals(tcn)).findFirst().get();		
	}
	
	public void deleteClaimByTcn(String type){
		list.removeIf(x -> x.getTcn().equals(type));
	}
	
	public void addClaim(Claim claim){
		list.add(claim);
	}
	
	public void updateClaimStatus(String tcn){
		list.stream().filter(x -> x.getTcn().equals(tcn)).findFirst().get().setStatus("paid");
	}
	
	/**
	 * restTemplate have the capabilty to maniplate another application which are running in different places.
	 * 
	 * restTemplate will expect target URL to connect with other aplications.
	 * 
	 * 
	 * 
	 */
	public List<Claim> getClaimsFulldataByTcn(String tcn) {
		
		Member member = null;
		Provider provider = null;
		
		ResponseEntity<Member> memberResponse = restTemplate.getForEntity("http://localhost:2021/getMember/123A1", Member.class);
		if(memberResponse.getStatusCode().equals(HttpStatus.OK)){
			System.out.println("memberResponse == " + memberResponse);
			member = restTemplate.getForObject("http://localhost:2021/getMember/123A1", Member.class);
		}		
		ResponseEntity<Provider> providerResponse = restTemplate.getForEntity("http://localhost:2022/getProvider/1234", Provider.class);
		if(providerResponse.getStatusCode().equals(HttpStatus.OK)){
			System.out.println("providerResponse === " + providerResponse);
			provider =  restTemplate.getForObject("http://localhost:2022/getProvider/1234", Provider.class);
		}
		
		//Claim claim1 = new Claim("9123456789001", "institunal" , "suspense");
		Claim claim1 = getClaimByTcn(tcn);
		claim1.setProvider(provider);
		claim1.setMember(member);		
		List<Claim> list1 = new ArrayList<Claim>();
		list1.add(claim1);
		
		System.out.println(" member data ---- ");
		System.out.println(member.getId() + " " + member.getName() + " " + member.getEligiblity());
		System.out.println(" provider data ---- ");
		System.out.println(provider.getId() + " " + provider.getName() + " " + provider.getType());
		return list1;
	}
	
	/**
	 * This will execute using GET request from the claim app.
	 * 
	 * Internally this will hit the providerApp put request by framing all nessary objects.
	 */
	public void addingNewProviderFromClaim() {
		System.out.println(" adding new provider for calim -- @start ");
		HttpEntity<Provider> request = new HttpEntity<>(new Provider("1238", "providerThrougCliam", "editable"));
		restTemplate.postForObject("http://localhost:2022/addProvider", request, Provider.class);
		System.out.println(" adding new provider for calim -- @End ");
	}
}
