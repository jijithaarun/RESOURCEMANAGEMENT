package com.resource.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resource.app.model.ResourceDetails;
import com.resource.app.model.Response;
import com.resource.app.service.iResourceDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ResourceDetailsController {

	@Autowired
	private iResourceDetailsService resourceDetailsService;

	@PostMapping("resourcedetails")
	public ResponseEntity<Response> addResource(@RequestParam("file") MultipartFile file,@RequestParam("resource") String resource) throws JsonMappingException, JsonProcessingException,IOException 
	{
		ResourceDetails resourceDet=new ObjectMapper().readValue(resource, ResourceDetails.class);
		//resourceDet.setPhoto(file.getBytes());
		resourceDet.setPicturePath("D:/resourcemanagement/src/assets/image/"+file.getOriginalFilename());
		ResourceDetails resourceDtls=resourceDetailsService.addResource(resourceDet);
		
		if(resourceDtls!=null)
		{
		return new ResponseEntity<Response>(new Response("resource details saved success"),HttpStatus.OK);
		}else
		{
			return new ResponseEntity<Response> (new Response("resource details saved not success"),HttpStatus.BAD_REQUEST);
		}
	}
	/*// add resourceDetails
	@PostMapping("resourcedetails")
	public ResponseEntity<ResourceDetails> addResource(@RequestBody ResourceDetails resource) {
		return new ResponseEntity<ResourceDetails>(resourceDetailsService.addResource(resource), HttpStatus.OK);
	}*/

	// edit resourceDetails
	@PutMapping("resourcedetails")
	public ResponseEntity<ResourceDetails> updateResource(@RequestBody ResourceDetails resource) {
		return new ResponseEntity<ResourceDetails>(resourceDetailsService.updateResource(resource), HttpStatus.OK);
	}

	// update resource details active column
	@PutMapping("resourcedetails-active/{resourceId}&{isActive}")
	public void updateIsactive(@PathVariable("resourceId") Long resourceId,
			@PathVariable("isActive") Character isActive) {
		resourceDetailsService.updateIsactive(isActive, resourceId);

	}

	// update resource details booked
	@PutMapping("resourcedetails-booked/{resourceId}&{isBooked}")
	public void updateIsBooked(@PathVariable("resourceId") Long resourceId,
			@PathVariable("isBooked") Character isBooked) {
		resourceDetailsService.updateIsBooked(isBooked, resourceId);

	}

	// update is accepted details
	@PutMapping("resourcedetails-accepted/{resourceId}&{isAccepted}")
	public void updateIsAccepted(@PathVariable("resourceId") Long resourceId,
			@PathVariable("isAccepted") Character isAccepted) {
		resourceDetailsService.updateIsAccepted(isAccepted, resourceId);
	}

	// find resource by i d
	@GetMapping("resourcedetails-id/{resourceId}")
	public ResponseEntity<ResourceDetails> findResourceById(@PathVariable("resourceId") Long resourceId) {
		System.out.println("searching resources");
		ResponseEntity<ResourceDetails> response = null;
		ResourceDetails resource = resourceDetailsService.findResourceById(resourceId);
		if (resource == null) {
			response = new ResponseEntity<ResourceDetails>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<ResourceDetails>(resource, HttpStatus.OK);
		}
		return response;
	}

	// find resource by name
	@GetMapping("resourcedetails-by-name/{resourceType}")
	public List<ResourceDetails> findResourceByName(@PathVariable("resourceType") String resourceType) {
		System.out.println("searching resources");
		List<ResourceDetails> viewResourceDetails = resourceDetailsService.findResourcesByName(resourceType);
		return viewResourceDetails;
	}

	// get all the resource details
	@GetMapping("resourcedetails")
	public ResponseEntity<List<ResourceDetails>> listAllResources() {
		return new ResponseEntity<List<ResourceDetails>>(resourceDetailsService.listAllResource(), HttpStatus.OK);
	}
	
	// get all the resource details when is active =y
		@GetMapping("resourcedetails-isactive")
		public ResponseEntity<List<ResourceDetails>> listResourcesDetails() {
			return new ResponseEntity<List<ResourceDetails>>(resourceDetailsService.listResourceDetails(), HttpStatus.OK);
		}

}
