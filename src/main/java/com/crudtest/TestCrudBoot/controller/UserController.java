package com.crudtest.TestCrudBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atlassian.connect.spring.AtlassianHostUser;
import com.crudtest.TestCrudBoot.repository.User;
import com.crudtest.TestCrudBoot.service.SavedValueService;

@Controller
public class UserController {

	
	@Autowired
	SavedValueService savedvalueService;

	  
	
	 

	//@GetMapping("/signup")
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showSignupForm(@AuthenticationPrincipal AtlassianHostUser hostUser,User user) {
		System.out.println("inside signup");
		return "add-user";
	}

	@SuppressWarnings("unchecked")
	//@PostMapping("/adduser")
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addUser(@AuthenticationPrincipal AtlassianHostUser hostUser, @ModelAttribute("name") String name, @ModelAttribute("email") String email, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("inside if if errors");
			return "add-user";
		} else {
		
			
			System.out.println("userRepository--------------------"+name);
			savedvalueService.insertUser(name, email);
			System.out.println("inside else");
			//Iterable<User> all = userRepository.findAll();
			model.addAttribute("users", null);
			return "index";
		}
		
	
		
	}
	

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/edit/{id}") public String
	 * showUpdateForm(@AuthenticationPrincipal AtlassianHostUser
	 * hostUser,@PathVariable("id") long id, Model model) {
	 * 
	 * try { User user = userRepository.findOne(id);
	 * 
	 * model.addAttribute("user", user); } catch (IllegalArgumentException e) {
	 * e.printStackTrace(); }
	 * 
	 * return "update-user"; }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @PostMapping("/update/{id}") public String
	 * updateUser(@AuthenticationPrincipal AtlassianHostUser
	 * hostUser,@PathVariable("id") long id, @Valid User user, Model model,
	 * BindingResult result) { if (result.hasErrors()) { user.setId(id); return
	 * "update-user"; } userRepository.save(user); model.addAttribute("users",
	 * userRepository.findAll()); return "index"; }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @GetMapping("/delete/{id}") public String deleteUser(@AuthenticationPrincipal
	 * AtlassianHostUser hostUser,@PathVariable("id") long id, Model model) {
	 * 
	 * try { User user = userRepository.findOne(id); userRepository.delete(user); }
	 * catch (IllegalArgumentException e) { e.printStackTrace(); }
	 * 
	 * model.addAttribute("users", userRepository.findAll()); return "index"; }
	 * 
	 */}
