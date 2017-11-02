package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name = "House")
public class House {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "post"))
	@Column(name = "houseID", unique=true, nullable = false)
	private long houseID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "status")
	private String status;
	
	@Transient
	private CommonsMultipartFile photo; 
	
	@Column(name = "filename")
	private String filename;
	
	@ManyToOne
	private HouseHolder owner;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private TravelPlan travelplan;
	
	@OneToMany(mappedBy = "house")//name must be unified with the attribute name in its mapping class
	private Set<Request> requests = new HashSet<Request>();
	
	public House() {
		
	}
	
	public long getHouseID() {
		return houseID;
	}

	public void setHouseID(long houseID) {
		this.houseID = houseID;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	public HouseHolder getOwner() {
		return owner;
	}

	public void setOwner(HouseHolder owner) {
		this.owner = owner;
	}

	public TravelPlan getTravelplan() {
		return travelplan;
	}

	public void setTravelplan(TravelPlan travelplan) {
		this.travelplan = travelplan;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}
	
}
