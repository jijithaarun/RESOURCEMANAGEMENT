package com.resource.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.app.model.Registration;
import com.resource.app.model.ResourceDetails;
import com.resource.app.model.RoleDetails;
import com.resource.app.service.iRoleDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class RoleDetailsController {
	
	@Autowired
	private iRoleDetailsService roleDetailsService;
	
	//add to roleDetails table
	@PostMapping("roledetails") // get the registration
	public ResponseEntity<RoleDetails> addRole(@RequestBody RoleDetails roleDetails) {

		return new ResponseEntity<RoleDetails>(roleDetailsService.addRoleDetails(roleDetails), HttpStatus.OK);

	}
	
	@GetMapping("roledetails")
	public ResponseEntity<List<RoleDetails>> listRoleDetails()
	{
		return new ResponseEntity<List<RoleDetails>>(roleDetailsService.listRoleDetails(),HttpStatus.OK);
	}
	
	
	/*// find registration by name
	@GetMapping("registration/{courseName}")
	public List<Registration> findRegisterByName(@PathVariable("courseName") String courseName) {

		List<Registration> viewRegisterDetails = registrationService.findRegistrationByName(courseName);
		return viewRegisterDetails;
	}*/
	
	
	//find roledetails by id
	@GetMapping("roledetails-by-id/{roleId}")
	public ResponseEntity<RoleDetails> findRoleDetailsById(@PathVariable("roleId") Integer roleId )
	{
		ResponseEntity<RoleDetails> response=null;	
		RoleDetails viewRoleDetails=roleDetailsService.findByRoleId(roleId);
		if(viewRoleDetails==null)
		{
			response=new ResponseEntity<RoleDetails>(HttpStatus.NOT_FOUND);
		}else
		{
			response=new ResponseEntity<RoleDetails>(viewRoleDetails,HttpStatus.OK);
		}
		return response;
	}

}
