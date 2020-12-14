package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "request")
public class Request {

	private long id;
	private long time;
	private int user_id;
	private String event;
	
	public Request(long time, int user_id, String event) {
		super();
		this.time = time;
		this.user_id = user_id;
		this.event = event;
	}
	
	public Request( ) {

	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    
	@Column(name = "time", nullable = false)
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	@Column(name = "user", nullable = false)
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Column(name = "event", nullable = false)
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
}
