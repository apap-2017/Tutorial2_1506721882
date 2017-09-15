package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting (@RequestParam(value = "name", defaultValue = "dunia")String name, Model model ) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value = {"/greeting/", "/greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()){
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	 public String multiplication(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		  model.addAttribute("num1", a);
		  model.addAttribute("num2", b);
		  int c = a*b; //rumus
		  model.addAttribute("num3", c); //hasil
		  return "perkalian";
	}
}
