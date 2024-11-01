package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String top() {
		return "Top";
	}
	
	@GetMapping("/About")
	public String about() {
		return "public/about";
	}
	
	@GetMapping("/Privacy")
	public String privacy() {
		return "public/privacy";
	}
	
	@GetMapping("/Terms")
	public String terms() {
		return "public/terms";
	}

}
