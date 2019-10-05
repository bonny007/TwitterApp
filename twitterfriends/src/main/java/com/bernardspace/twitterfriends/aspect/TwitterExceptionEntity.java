package com.bernardspace.twitterfriends.aspect;

public class TwitterExceptionEntity {

private int statuscode;
	
	private String messagebody;
	
	private long timestamp;

	public TwitterExceptionEntity() {
		
	}
	
	
	public TwitterExceptionEntity(int statuscode, String messagebody, long timestamp) {
		this.statuscode = statuscode;
		this.messagebody = messagebody;
		this.timestamp = timestamp;
	}


	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessagebody() {
		return messagebody;
	}

	public void setMessagebody(String messagebody) {
		this.messagebody = messagebody;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}
