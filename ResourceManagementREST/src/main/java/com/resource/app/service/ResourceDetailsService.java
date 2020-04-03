package com.resource.app.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.ResourceDetails;
import com.resource.app.repository.iResourceDetailsRepo;

@Service
public class ResourceDetailsService implements iResourceDetailsService {

	@Autowired
	private iResourceDetailsRepo resourceDetailsRepo;

	@Transactional
	@Override
	public ResourceDetails addResource(ResourceDetails resourceDetails) {

		return resourceDetailsRepo.save(resourceDetails);
	}

	@Transactional
	@Override
	public ResourceDetails updateResource(ResourceDetails resourceDetails) {

		return resourceDetailsRepo.save(resourceDetails);
	}

	@Transactional
	@Override
	public void updateIsactive(Character isActive, Long resourceId) {

		resourceDetailsRepo.save(isActive, resourceId);
	}

	@Transactional
	@Override
	public void updateIsBooked(Character isBooked, Long resourceId) {
		resourceDetailsRepo.saveIsBooked(isBooked, resourceId);

	}

	@Transactional
	@Override
	public void updateIsAccepted(Character isAccepted, Long resourceId) {
		resourceDetailsRepo.saveIsAccepted(isAccepted, resourceId);

	}

	@Override
	public List<ResourceDetails> listAllResource() {

		return resourceDetailsRepo.listAllResource();
	}

	@Override
	public ResourceDetails findResourceById(Long resourceId) {
		Optional<ResourceDetails> findResourceId = resourceDetailsRepo.findById(resourceId);
		ResourceDetails resourceDetails = findResourceId.isPresent() ? findResourceId.get() : null;
		return resourceDetails;
	}

	@Override
	public List<ResourceDetails> findResourcesByName(String resourceName) {
		List<ResourceDetails> viewResourceName = resourceDetailsRepo.findByResource(resourceName);
		return viewResourceName;

	}

	@Override
	public List<ResourceDetails> listResourceDetails() {

		return resourceDetailsRepo.listResourcedetails();
	}

	@Override
	public Optional<ResourceDetails> findImage(String imageName) {

		return resourceDetailsRepo.findImage(imageName);
	}

}
