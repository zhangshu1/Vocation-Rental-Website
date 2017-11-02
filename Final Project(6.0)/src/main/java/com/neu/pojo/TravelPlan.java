package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="TravelPlan")
public class TravelPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "post"))
	@Column(name = "planID", unique=true, nullable = false)
	private long planID;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "numberOfPeople")
	private int numberOfPeople;
	
	@OneToOne(mappedBy = "travelplan", cascade = CascadeType.ALL)
	private House house;
	
	@ManyToMany(mappedBy="travelplans")
	private Set<User> members = new HashSet<User>();
	
	public TravelPlan() {
		
	}
	
	public long getPlanID() {
		return planID;
	}
	public void setPlanID(long planID) {
		this.planID = planID;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	
	
}
