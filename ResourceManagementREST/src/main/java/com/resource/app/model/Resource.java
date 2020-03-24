package com.resource.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resources")
public class Resource {
	
	//instance variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resourceTypeId;
	
	@Column(nullable = false,length=20)//create column with not null
	private String resourceType;
	
	
	public Long getResourceTypeId() {
		return resourceTypeId;
	}


	public void setResourceTypeId(Long resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}


	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}




	
}
