package com.bernardspace.twitterfriends.entity;

public class MutualFriend {

	private long id;
	
	private String name;

	public MutualFriend(long id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MutualFriend [id=" + id + ", name=" + name + "]";
	}
}
