package com.resource.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resource.app.model.Registration;
import com.resource.app.model.ResourceDetails;
import com.resource.app.model.Response;
import com.resource.app.service.iRegistrationService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class RegistrationController {


	@Autowired
	iRegistrationService registrationService;

	// list registration  details
	@GetMapping("registration")
	public ResponseEntity<List<Registration>> listRegistration() {

		return new ResponseEntity<List<Registration>>(registrationService.listRegistration(), HttpStatus.OK);

	}

/*//add to registration table
	@PostMapping("registration") // get the registration
	public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration) {

		return new ResponseEntity<Registration>(registrationService.addRegistration(registration), HttpStatus.OK);

	}*/
	
	@PostMapping("registration")
	public ResponseEntity<Response> addRegistration(@RequestParam("imageFile") MultipartFile file,@RequestParam("registration") String registration) throws JsonMappingException, JsonProcessingException,IOException
	{
		Registration registrationDetails=new ObjectMapper().readValue(registration, Registration.class);
		registrationDetails.setPhoto(compressBytes(file.getBytes()));
		registrationDetails.setPictureName(file.getOriginalFilename());
		//registrationDetails photo=new Registration(file.getOriginalFilename(),file.getContentType());
		Registration registrationDet=registrationService.addRegistration(registrationDetails);
		
		if(registrationDet!=null)
		{
		return new ResponseEntity<Response>(new Response("resource details saved success"),HttpStatus.OK);
		}else
		{
			return new ResponseEntity<Response> (new Response("resource details saved not success"),HttpStatus.BAD_REQUEST);
		}
		
	}

	// find registration by name
	@GetMapping("registration/{courseName}")
	public List<Registration> findRegisterByName(@PathVariable("courseName") String courseName) {

		List<Registration> viewRegisterDetails = registrationService.findRegistrationByName(courseName);
		return viewRegisterDetails;
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


}
