package com.example.controller;


import java.util.Optional;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.entity.Member;
import com.example.entity.Tours;
import com.example.entity.question;
import com.example.repo.ToursRepo;
import com.example.repo.employeeRepo;
import com.example.repo.memberRepo;
import com.example.repo.questionRepo;
import com.example.service.employeeService;
import com.example.service.memberService;
import com.example.service.questionService;
import com.example.service.toursService;


@Controller
public class MainController {

	@Autowired
	employeeRepo cRepo;
	
	@Autowired
	memberRepo mRepo;
	
	@Autowired
	ToursRepo tRepo;
	
	@Autowired
	questionRepo qRepo;
	
	@Autowired
	private employeeService cService;
	
	@Autowired
	private memberService mService;
	
	@Autowired
	private toursService tService;
	
	@Autowired
	private questionService qService;
	
	@GetMapping("/membertour/{id}")
	public String showMemberTour(@ModelAttribute("member") Member member, @PathVariable (value = "id") int id, Model model) {

		Member memb = mService.getMemberById(id);
		
		Set<Tours> MemTours = mService.getMemberTours(memb.getId());

		// add it to the model
		model.addAttribute("memTours", MemTours);
		// add the customer to the model as the user
		model.addAttribute("member", member);
		// return to the page
		
		//model.addAttribute("memtours", )
		return "/membertours";
	}
	
	
	
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		
		cRepo.save(employee);
		
		return "Home";
	}
	
	@RequestMapping("/addTour")
	public String addTour(Tours tour) {
		
		tRepo.save(tour);
		
		return "Home";
	}

	@GetMapping("/list")
	public String viewEmployees(Model theModel) {
		theModel.addAttribute("listEmployees", cService.getAllEmployees());
		
		return "employee_info";
	}
	
	@GetMapping("/listmembers")
	public String viewMembers(Model theModel) {
		
		theModel.addAttribute("listMembers", mService.getAllMembers());
		
		return "member_info";
	}
	@GetMapping("/listtours")
	public String viewTours(Model theModel) {
		
		theModel.addAttribute("listTours", tService.getAllTours());
		
		return "tour_info";
	}
	@GetMapping("/listquestions")
	public String viewQuestions(Model theModel) {
		
		theModel.addAttribute("listQuestions", qService.getAllQuestions());
		
		return "question_info";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") int id, Model theModel) {
		// get customer from the service
		Employee employee = cService.getEmployeeById(id);
		
		//set employee as a model attribute to pre-populate the form
		theModel.addAttribute("employee", employee);
		
		return "update_employee";
	}
	@GetMapping("/showFormForUpdateTour/{id}")
	public String showFormForUpdateTour(@PathVariable (value = "id") int id, Model theModel) {
		// get customer from the service
		Tours tour = tService.getTourById(id);
		
		//set employee as a model attribute to pre-populate the form
		theModel.addAttribute("tour", tour);
		
		return "update_tour";
	}
	@GetMapping("/showNewMemberTourForm/{id}")
	public String showNewMemberTourForm(@PathVariable (value ="id") int id, Model theModel) {
		Tours tour = new Tours();
		
		theModel.addAttribute("tour", tour);
		
		return "tour_registration";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model theModel) {
		Employee employee = new Employee();
		
		theModel.addAttribute("employee", employee);
		
		return "New_Employee";
	}
	@GetMapping("/showNewTourForm")
	public String showNewTourForm(Model theModel) {
		Tours tour = new Tours();
		
		theModel.addAttribute("tour", tour);
		
		return "New_Tour";
	}
	
	@GetMapping("/showNewTourRegForm")
	public String showNewTourRegForm(Model theModel) {
		Tours tours = new Tours();
		
		theModel.addAttribute("tours", tours);
		
		return "tourregistration";
	}
	

	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		cService.saveEmployee(employee);
		
		return "redirect:/list";
		
	}
	@PostMapping("/saveMember")
	public String saveEmployee(@ModelAttribute("member") Member member) {
		// save employee to database
		mService.saveMember(member);
		
		return "redirect:/ThankYou";
		
	}
	@PostMapping("/saveQuestion")
	public String saveQuestion(@ModelAttribute("question") question question) {
		// save employee to database
		qService.saveQuestion(question);
		
		return "redirect:/AboutUs";
		
	}
	@PostMapping("/saveTour")
	public String saveTour(@ModelAttribute("tour") Tours tour) {
		// save employee to database
		tService.saveTour(tour);
		
		return "redirect:/Home";
		
	}
	
	@PostMapping("/saveMemberToTour")
	public String saveMemberToTour(@ModelAttribute("tours") Tours tours) {
		// save Tour to database
		tService.saveTour(tours);
		
		return "redirect:/AfricanSavanna";
		
	}
	
	@PostMapping("/searchMember")
	public String searchMember(@ModelAttribute("member") Member member) {
		
		mService.getMemberById(member.getId());
		
		return "redirect:/membertours";
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") int id) {
		// call delete customer method
		
		this.cService.deleteEmployeeById(id);
		
		return "redirect:/list";
		
	}
	@GetMapping("/deleteTour/{id}")
	public String deleteTour(@PathVariable (value = "id") int id) {
		// call delete customer method
		
		this.tService.deleteTourById(id);
		
		return "redirect:/list";
		
	}
	
	
	@GetMapping("/tourregistration")
	public String goRegister() {
		return "tourregistration";
	}
	
	@GetMapping("/Home")
	public String goHome() {
		return "Home";
	}
	@GetMapping("/AboutUs")
	public String goAboutUs() {
		return "AboutUs";
	}
	@GetMapping("/AfricanSavanna")
	public String goAfricanSavanna() {
		return "AfricanSavanna";
	}
	@GetMapping("/AmazonRainforest")
	public String goAmazonRainforest() {
		return "AmazonRainforest";
	}
	@GetMapping("/ThankYou")
	public String goThankYou() {
		return "ThankYou";
	}
	@GetMapping("/member_info")
	public String goMember_info() {
		return "member_info";
	}
	@GetMapping("/question_info")
	public String goQuestion_info() {
		return "question_info";
	}
	
	@GetMapping("/tour_info")
	public String goTour_info() {
		return "tour_info";
	}
	@GetMapping("/employee_info")
	public String goEmployee_info() {
		return "employee_info";
	}
	@RequestMapping("/MemSignUp")
	public String goMemSignUp(Model theModel) {
		Member member = new Member();
		
		theModel.addAttribute("member", member);
		
		return "MemSignUp";
	}
	
		
}
