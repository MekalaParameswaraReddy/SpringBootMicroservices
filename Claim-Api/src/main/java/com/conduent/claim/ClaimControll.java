package com.conduent.claim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conduent.claim.bean.Claim;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@RestController
public class ClaimControll {
	
	//@Autowired : is like consumer; somewhere your object is available, please use it.
	@Autowired
	CliamService cliamService;
	 
	@RequestMapping("/getClaims")
	public List<Claim> getClaims(){
		return cliamService.getClaims();
	}
	
	@RequestMapping("/getClaim/{tcnNumber}")
	public Claim getClaimByTcn(@PathVariable("tcnNumber") String tcn){
		return cliamService.getClaimByTcn(tcn);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value = "/deleteClaimByTcn/{ByType}")
	public void deleteClaimByTcn(@PathVariable("ByType") String tcn){
		cliamService.deleteClaimByTcn(tcn);
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/addClaim")
	public void addClaim(@RequestBody Claim claim){
		cliamService.addClaim(claim);
	}
	
	/**
	 * Compile time error, with only change of RequestMethod.PUT : duplicate method.
	 * 
	 */
	/*@RequestMapping(method= RequestMethod.PUT, value = "/addClaim")
	public void addClaim(@RequestBody Claim claim){
		cliamService.addClaim(claim);
	}*/
	
	@RequestMapping(method= RequestMethod.PUT, value = "/updateClaimStatus/{tcnNumber}")
	public void updateClaimStatus(@PathVariable("tcnNumber") String tcn){
		cliamService.updateClaimStatus(tcn);
	}
	
	@RequestMapping("/getClaimsFulldataByTcn/{ByTcn}")
	public List<Claim> getClaimsFulldataByTcn(@PathVariable("ByTcn") String tcn){
		return cliamService.getClaimsFulldataByTcn(tcn);
	}
	
	
	//
	@RequestMapping("/addingNewProviderFromClaim")
	public void addingNewProviderFromClaim() {
		cliamService.addingNewProviderFromClaim();
	}
}
