package com.resource.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ResourceDetails {
	// insatnce variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resourceId;

	
	public ResourceDetails( String picturePath,byte[] photo) {
		super();
		this.photo = photo;
		this.picturePath = picturePath;
	}

	// getting the values from the resource tables and set to foreign key
	@ManyToOne
	@JoinColumn(name = "resourceTypeId")
	private Resource resource;

	@Column(nullable = false, length = 8) // create column with not null
	private Integer resourceCapacity;

	@Column(nullable = false, length = 8) // create column with not null
	private Integer noOfSystems;

	@Column(nullable = false) // create column with not null
	private Character projector;

	@Column(nullable = false) // create column with not null
	private Character whiteBoard;
	@Column(length=1000)
	private byte[] photo;
	private String picturePath;

	@Column(nullable = false) // create column with not null
	private Float resourceRate;

	private String typeOfUse;

	private Character isAccepted;

	private Character isBooked;

	private Character isActive;

	public ResourceDetails() {
		super();

	}

	public ResourceDetails(ResourceDetails updateIsactive) {

	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Integer getResourceCapacity() {
		return resourceCapacity;
	}

	public void setResourceCapacity(Integer resourceCapacity) {
		this.resourceCapacity = resourceCapacity;
	}

	public Integer getNoOfSystems() {
		return noOfSystems;
	}

	public void setNoOfSystems(Integer noOfSystems) {
		this.noOfSystems = noOfSystems;
	}

	public Character getProjector() {
		return projector;
	}

	public void setProjector(Character projector) {
		this.projector = projector;
	}

	public Character getWhiteBoard() {
		return whiteBoard;
	}

	public void setWhiteBoard(Character whiteBoard) {
		this.whiteBoard = whiteBoard;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Float getResourceRate() {
		return resourceRate;
	}

	public void setResourceRate(Float resourceRate) {
		this.resourceRate = resourceRate;
	}

	public String getTypeOfUse() {
		return typeOfUse;
	}

	public void setTypeOfUse(String typeOfUse) {
		this.typeOfUse = typeOfUse;
	}

	public Character getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Character isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Character getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Character isBooked) {
		this.isBooked = isBooked;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

}
