package com.example.Palvelinohjelmointi.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Palvelinohjelmointi.domain.Friend;

@Controller
public class FriendController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String friendForm(Model model) {
		
		Friend friend1 = new Friend();
		friend1.setName("John Doe");
		List<Friend> friends = new ArrayList<Friend>();
		friends.add(friend1);
		model.addAttribute("friends", friends);
		model.addAttribute("friend", new Friend());
		return "index";
		
	}
	
	@GetMapping("/result")
	public String resultAccess(Model model) {
		return "result";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String friendSubmit(@ModelAttribute Friend name, @Valid BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "redirect:/index";
			
		}
		model.addAttribute("friends", name);
		return "result";
	}
}