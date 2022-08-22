package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.entity.Member;
import com.example.entity.Tours;
import com.example.repo.ToursRepo;
import com.example.repo.employeeRepo;
import com.example.repo.memberRepo;
import com.example.service.employeeService;
import com.example.service.memberService;
import com.example.service.toursService;

@RestController
@RequestMapping("/api")
public class RestControllerone {
	
	@Autowired
	employeeRepo cRepo;
	
	@Autowired
	memberRepo mRepo;
	
	@Autowired
	ToursRepo tRepo;
	
	@Autowired
	private employeeService cService;
	
	@Autowired
	private memberService mService;
	
	@Autowired
	private toursService tService;
	
	
	@GetMapping("/Members")
	public List<Member> viewEmployees(Model theModel) {
		
		return mService.getAllMembers();
	}
	@GetMapping("/Members/{MemberId}")
	public Member getMember(@PathVariable int MemberId) throws Exception {
		Member theMember = mService.getMemberById(MemberId);
		
		return theMember;
	}
	
	
}
