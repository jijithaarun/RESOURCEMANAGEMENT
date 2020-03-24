package com.resource.app.service;

import java.util.List;

import com.resource.app.model.ResourceDetails;

public interface iResourceDetailsService {
	public ResourceDetails addResource(ResourceDetails resourceDetails);

	public ResourceDetails updateResource(ResourceDetails resourceDetails);

	public List<ResourceDetails> listAllResource();

	public ResourceDetails findResourceById(Long resourceId);

	public List<ResourceDetails> findResourcesByName(String resourceName);

	public void updateIsactive(Character isActive, Long resourceId);
	
	public void updateIsBooked(Character isBooked, Long resourceId);
	
	public void updateIsAccepted(Character isAccepted, Long resourceId);
	
	public List<ResourceDetails> listResourceDetails();

}
