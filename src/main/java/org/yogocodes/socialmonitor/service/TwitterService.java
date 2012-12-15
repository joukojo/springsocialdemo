package org.yogocodes.socialmonitor.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchOperations;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.TimelineOperations;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.UserOperations;
import org.springframework.stereotype.Service;

@Service("twitterService")
public class TwitterService {

	private final static Logger LOG = LoggerFactory
			.getLogger(TwitterService.class);

	private final Twitter twitter;

	@Autowired
	public TwitterService(Twitter twitter) {
		this.twitter = twitter;

	}

	public List<Tweet> getTweetsForHashtag(String hashTag) {

		final SearchOperations searchOperations = twitter.searchOperations();

		final SearchResults results = searchOperations.search("" + '#' + hashTag, 1, 500);

		final List<Tweet> tweets = results.getTweets();

		if (LOG.isDebugEnabled()) {
			for (Tweet tweet : tweets) {
				LOG.debug(tweet.getText());
				LOG.debug(tweet.getFromUser());
				LOG.debug("user id {}", tweet.getFromUserId());
			}
		}

		return tweets;
	}

	public List<Tweet> getTweetsForUser(String username) {
		TimelineOperations timelineOperations = twitter.timelineOperations();
		
		List<Tweet> tweets = timelineOperations.getUserTimeline(username);
		
		if (LOG.isDebugEnabled()) {
			for (Tweet tweet : tweets) {
				LOG.debug(tweet.getText());
				LOG.debug(tweet.getFromUser());
				LOG.debug("user id {}", tweet.getFromUserId());
			}
		}
		
		return tweets;
		
	}

	public Tweet getTweetById(Long tweetId) {
		TimelineOperations timelineOperations = twitter.timelineOperations();
		
		return timelineOperations.getStatus(tweetId);
	}

	public TwitterProfile getUser(String userId) {
		UserOperations userOperations = twitter.userOperations();
		return userOperations.getUserProfile(userId);
	}
	
	

}
