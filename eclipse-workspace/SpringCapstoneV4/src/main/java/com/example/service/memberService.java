package com.example.service;

import java.util.List;
import java.util.Set;

import com.example.entity.Member;
import com.example.entity.Tours;

public interface memberService {
	
	List<Member> getAllMembers();
	
	Member getMemberById(int id);
	
	void saveMember(Member member);
	
	void deleteMemberById(int id);
	
	public Set<Tours> getMemberTours(Integer id);
}
