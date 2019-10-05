package com.bernardspace.twitterfriends.service;

import java.util.List;

import com.bernardspace.twitterfriends.entity.MutualFriend;

public interface TwitterFriendService {

	List<MutualFriend> getMutualFriends(String user1handle, String user2handle) throws Exception;
	
	
}
