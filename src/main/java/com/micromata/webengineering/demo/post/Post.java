package main.java.com.micromata.webengineering.demo.post;

import java.util.UUID;

public class Post {

	private long timestamp; //Exercise: time of creation
	private String message; //post content
	private UUID guid;
	
	Post(String message) 
	{
		this.timestamp = System.currentTimeMillis();
		this.guid = java.util.UUID.randomUUID();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public UUID getGuid() {
		return guid;
	}
	
	public void setGuid(UUID guid) {
		this.guid = guid;
	}
	
	@Override
	public String toString()
	{
		return this.timestamp + ": " + this.message; 
	}
	
}
