package com.resource.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
	public ResponseEntity<Response> addResource(@RequestParam("file") MultipartFile file,
			@RequestParam("resource") String resource)
			throws JsonMappingException, JsonProcessingException, IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ResourceDetails resourceDet = new ObjectMapper().readValue(resource, ResourceDetails.class);
		resourceDet.setPhoto(compressBytes(file.getBytes()));
		resourceDet.setPicturePath(file.getOriginalFilename());
		ResourceDetails resourceDtls = resourceDetailsService.addResource(resourceDet);

		if (resourceDtls != null) {
			return new ResponseEntity<Response>(new Response("resource details saved success"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("resource details saved not success"),
					HttpStatus.BAD_REQUEST);
		}
	}
	/*
	 * // add resourceDetails
	 * 
	 * @PostMapping("resourcedetails") public ResponseEntity<ResourceDetails>
	 * addResource(@RequestBody ResourceDetails resource) { return new
	 * ResponseEntity<ResourceDetails>(resourceDetailsService.addResource(resource),
	 * HttpStatus.OK); }
	 */

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
	
	@GetMapping("resourcedetails-image")
	public ResourceDetails getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<ResourceDetails> retrievedImage = resourceDetailsService.findImage(imageName);
		
		ResourceDetails img = new ResourceDetails(retrievedImage.get().getPicturePath(),
				decompressBytes(retrievedImage.get().getPhoto()));
		return img;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
