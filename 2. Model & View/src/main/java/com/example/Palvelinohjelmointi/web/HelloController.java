package com.example.Palvelinohjelmointi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
	
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(name="name", required=false, defaultValue="noName") String name, Model model, @RequestParam(name="age", required=false, defaultValue="0") String age, Model model2) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}

}
