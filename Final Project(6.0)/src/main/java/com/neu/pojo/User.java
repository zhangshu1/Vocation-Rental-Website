package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name="User")
@PrimaryKeyJoinColumn(name = "personID")
public class User extends Person{
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Transient
	private CommonsMultipartFile photo;
	
	@Column(name = "filename")
	private String filename;
	
	@OneToMany(mappedBy = "sender")//name must be unified with the attribute name in its mapping class
	private Set<Request> requests = new HashSet<Request>();
	
	@ManyToMany
    @JoinTable (
       name="User-TravelPlan",
       joinColumns = {@JoinColumn(name="personID", nullable = false, updatable = false)},
       inverseJoinColumns = {@JoinColumn(name="planID" )}
    )
	private Set<TravelPlan> travelplans = new HashSet<TravelPlan>();
	
	public User () {
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CommonsMultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

//	public Set<Request> getRequests() {
//		return requests;
//	}
//
//	public void setRequests(Set<Request> requests) {
//		this.requests = requests;
//	}

//	public Set<TravelPlan> getTravelplans() {
//		return travelplans;
//	}
//
//	public void setTravelplans(Set<TravelPlan> travelplans) {
//		this.travelplans = travelplans;
//	}
	
}
