package com.bernardspace.twitterfriends.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TwitterHandlesForm {
	
	@NotNull(message = "Can't be empty")
	@Pattern(regexp = "^@([a-z0-9A-Z_]{1,15})",message = "Invalid handle format")
	private String user1handle;
	
	@NotNull(message = "Can't be empty")
	@Pattern(regexp = "^@([a-z0-9A-Z_]{1,15})",message = "Invalid handle format")
	private String user2handle;
	
	public TwitterHandlesForm() {
	
	}
	public TwitterHandlesForm(String user1handle, String user2handle) {
		
		this.user1handle = user1handle;
		this.user2handle = user2handle;
	}

	public String getUser1handle() {
		return user1handle;
	}

	public void setUser1handle(String user1handle) {
		this.user1handle = user1handle;
	}

	public String getUser2handle() {
		return user2handle;
	}

	public void setUser2handle(String user2handle) {
		this.user2handle = user2handle;
	}
	@Override
	public String toString() {
		return "TwitterHandlesForm [user1handle=" + user1handle + ", user2handle=" + user2handle + "]";
	}
	
	
}
