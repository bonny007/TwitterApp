package com.bernardspace.twitterfriends.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bernardspace.twitterfriends.entity.MutualFriend;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class MutualFriendService implements TwitterFriendService {
	
	@Autowired
	private TwitterFactory twitterFactory;

	@Override
	public List<MutualFriend> getMutualFriends(String user1handle, String user2handle) throws TwitterException {
		
	    Twitter twitter = twitterFactory.getInstance();
		
	    Set<Long> user1friendIDs = Arrays.stream(twitter.getFriendsIDs(user1handle, -1).getIDs()).boxed().collect(Collectors.toSet());
		
		Set<Long> user2friendIDs = Arrays.stream(twitter.getFriendsIDs(user2handle, -1).getIDs()).boxed().collect(Collectors.toSet());
				
		Set<Long> mutualfriendIDs = user1friendIDs.stream().filter(friendid->user2friendIDs.contains(friendid)).collect(Collectors.toSet());
		
		List<MutualFriend> mutualfriends = new ArrayList<MutualFriend>();
				
		mutualfriendIDs.forEach(friendid->{
			try {
				 mutualfriends.add(new MutualFriend(friendid,twitter.showUser(friendid).getName()));
				} 
			catch (TwitterException e) {
					 e.printStackTrace();
				}
					 });
			
		
		return mutualfriends;
	}

}
