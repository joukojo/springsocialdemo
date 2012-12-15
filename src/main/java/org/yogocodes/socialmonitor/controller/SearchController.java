package org.yogocodes.socialmonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yogocodes.socialmonitor.service.TwitterService;


@Controller
public class SearchController {

	
	private final TwitterService twitterService;

	@Autowired
	public SearchController(TwitterService twitterService) {
		this.twitterService = twitterService;
		
	}
	
	@RequestMapping(value = "searchhashtag", method = RequestMethod.GET)
	public String searchHashtag(@RequestParam(value="tag") String tag, Model model) {
		
		List<Tweet> tweetsForHashtag = twitterService.getTweetsForHashtag(tag);
		
		model.addAttribute("tweets", tweetsForHashtag);
		return "searchresult";
	}
	
	@RequestMapping(value="searchuser", method=RequestMethod.GET)
	public String searchUserTweets(@RequestParam(value="user")String username, Model model) {
		
		List<Tweet> tweetsForUser = twitterService.getTweetsForUser(username);
		model.addAttribute("tweets", tweetsForUser);
		return "searchresult";
	}
	
}
