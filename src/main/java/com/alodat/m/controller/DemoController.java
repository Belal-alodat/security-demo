package com.alodat.m.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 

@RestController
public class DemoController {
	
	@GetMapping("/user1")
	public String user1() {
		return "user1"+ " "+getRole();
	}
	
	@GetMapping("/user2")
	public String user2() {
		return "user2"+ " "+getRole();
	}

	private String getRole(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles= new ArrayList<>(0);
		if ( authentication != null)
			return	authentication.getAuthorities().stream().map((role)-> role.toString()).collect(Collectors.joining(",", "{", "}"));
		 
		return "";
	}
}
