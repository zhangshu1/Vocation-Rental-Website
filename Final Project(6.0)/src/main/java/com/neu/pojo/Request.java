package com.neu.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "requestID", unique = true, nullable = false)
	private long requestID;
	
	@ManyToOne
//	@JoinColumn(name = "user", nullable = false)
	private User sender;
	
	@ManyToOne
//	@JoinColumn(name = "householder", nullable = false)
	private HouseHolder receiver;
	
	@ManyToOne
	private House house;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "date")
	private Date date;
	
	public Request() {
		
	}
	
	public long getRequestID() {
		return requestID;
	}
	
	public void setRequestID(long requestID) {
		this.requestID = requestID;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public HouseHolder getReceiver() {
		return receiver;
	}

	public void setReceiver(HouseHolder receiver) {
		this.receiver = receiver;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	
}
