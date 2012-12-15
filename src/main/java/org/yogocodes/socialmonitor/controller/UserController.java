package org.yogocodes.socialmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yogocodes.socialmonitor.service.TwitterService;

@Controller
public class UserController {

	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping(value="/viewuser", method=RequestMethod.GET)
	public String getUserById(@RequestParam(value="userid") String userId, Model model)  {
		
		TwitterProfile twitterProfile = twitterService.getUser(userId);
		
		model.addAttribute("user",twitterProfile);
		return "viewuser";
	}
	
	
}
