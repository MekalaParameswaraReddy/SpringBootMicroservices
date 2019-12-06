package com.conduent.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.conduent.member.bean.Member;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@Service
public class MemberService {
	
	List<Member> list = new ArrayList<>(Arrays.asList(new Member("123A1", "Rare alex", "eligible for medicaid"),
			new Member("123A2", "A.C peeter", "eligible for medicaid"),
			new Member("123A3", "fun bob", "eligible for medicaid"),
			new Member("123A4", "Mr. England", "eligible for medicaid")));

	public List<Member> getMembers(){
		System.out.println("Listing all members ...... ");
		return list;
	}
	
	public Member getMember(String id){
		System.out.println("Listing single member .......... ");
		return  list.stream().filter(x -> x.getId().equals(id)).findFirst().get();
	}
	
	public void addMember(Member member){
		System.out.println("adding member .......... ");
		list.add(member);
	}
	
	public void updateMember(String id){
		System.out.println("update member .......... ");
		list.stream().filter(x -> x.getId().equals(id)).findFirst().get().setEligiblity("Changed to Medicare");
	}
	
	public void deleteMember(String id){
		System.out.println("delete member .......... ");
		list.removeIf(x -> x.getId().equals(id));
	}
}
