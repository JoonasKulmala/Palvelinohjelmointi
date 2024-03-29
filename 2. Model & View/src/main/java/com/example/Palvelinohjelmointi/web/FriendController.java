package com.example.Palvelinohjelmointi.web;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Palvelinohjelmointi.domain.Friend;

@Controller
public class FriendController {
	
	private List<Friend> friends = new ArrayList<Friend>();

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String friendForm(Model model) {
		model.addAttribute("friends", friends);
		model.addAttribute("friend", new Friend());
		return "index";
		
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String friendSubmit(@ModelAttribute @Valid Friend name, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "redirect:/index";
			
		}
		friends.add(name);
		model.addAttribute("friend", name);
		return "result";
	}
}