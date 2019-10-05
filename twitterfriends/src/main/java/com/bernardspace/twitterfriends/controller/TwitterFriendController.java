package com.bernardspace.twitterfriends.controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bernardspace.twitterfriends.entity.MutualFriend;
import com.bernardspace.twitterfriends.entity.TwitterHandlesForm;
import com.bernardspace.twitterfriends.service.TwitterFriendService;

import twitter4j.TwitterException;

@Controller
@RequestMapping("/mutualfriend")
public class TwitterFriendController {

	@Autowired
	TwitterFriendService twitterfriendservice;
	
	@InitBinder
	public void removeWhiteSpaces(WebDataBinder webDataBinder ) {
		
		StringTrimmerEditor stringtrimmerEditor = new StringTrimmerEditor(true);
		
		webDataBinder.registerCustomEditor(String.class, stringtrimmerEditor);
	}
	
	@GetMapping("/form")
	public String getTwitterHandels(@ModelAttribute("handles") TwitterHandlesForm twitterhandleformdata,Model model) {
		
			model.addAttribute("handles", new TwitterHandlesForm("@handle","@handle"));
		
		return "handles-form";
	}
	
	@PostMapping("/list")
	public String getMutualFriends(@Valid @ModelAttribute("handles") TwitterHandlesForm twitterhandleformdata,BindingResult bindingResult,Model model) throws Exception {
	 
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("handles",twitterhandleformdata);
			return "handles-form";
		}
			
		List<MutualFriend> mutualfriends = twitterfriendservice.getMutualFriends(twitterhandleformdata.getUser1handle(),twitterhandleformdata.getUser2handle());
		
		model.addAttribute("mutualfriendlist",mutualfriends);

		return mutualfriends.size()==0 ? "nofriend" : "mutualfriend-list";
		
		
		
		
	
	}
	
}
