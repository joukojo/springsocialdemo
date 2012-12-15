package org.yogocodes.socialmonitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yogocodes.socialmonitor.service.TwitterService;

@Controller
public class TweetController {

	private final static Logger LOG = LoggerFactory.getLogger(TweetController.class);
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping(value="/viewtweet", method=RequestMethod.GET)
	public String getTweetById(@RequestParam(value="id") Long tweetId, Model model) {
		LOG.debug("getting tweet:{}", tweetId);
		Tweet tweet = twitterService.getTweetById(tweetId);
		model.addAttribute("tweet", tweet);
		return "viewtweet"; 
	}
	
	
}
