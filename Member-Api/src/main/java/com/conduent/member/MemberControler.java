package com.conduent.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.conduent.member.bean.Member;
/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@RestController
public class MemberControler {
	
	@Autowired
	MemberService memberService;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/getMembers")
	public List<Member> getMembers(){
		System.out.println("Listing all members ...... ");
		return memberService.getMembers();
	}
	
	@RequestMapping("/getMember/{memId}")
	public Member getMember(@PathVariable("memId") String id){
		return memberService.getMember(id);
	}
	
	@RequestMapping(method= RequestMethod.POST, value= "/addMember")
	public void addMember(@RequestBody Member member){
		System.out.println("adding member .......... ");
		memberService.addMember(member);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value= "/updateMember/{memId}")
	public void updateMember(@PathVariable("memId") String id){
		System.out.println("update member .......... ");
		memberService.updateMember(id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value= "/deleteMember/{memID}")	
	public void deleteMember(@PathVariable("memID") String id){
		System.out.println("delete member .......... ");
		memberService.deleteMember(id);
	}
}
