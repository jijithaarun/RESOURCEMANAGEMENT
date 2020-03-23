package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Resource;

public interface iResourceService {

	public Resource addResource(Resource resource);

	public Resource updateResource(Resource resource);

	public List<Resource> listAllResource();

	public Resource findResourceById(Long resourceTypeId);
	
	public Resource findResourcesByName(String resourceName);

	public void deleteResource(Long resourceTypeId);

}
