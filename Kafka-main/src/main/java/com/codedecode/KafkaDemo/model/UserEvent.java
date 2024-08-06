package com.codedecode.KafkaDemo.model;

import java.io.Serializable;

public class UserEvent implements Serializable{
	private int userId;
	private String eventType;
	private User user;
	
	
	
	@Override
	public String toString() {
		return "UserEvent [userId=" + userId + ", eventType=" + eventType + ", user=" + user + "]";
	}

	public UserEvent(int userId, String eventType, User user) {
		super();
		this.userId = userId;
		this.eventType = eventType;
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
		
}
