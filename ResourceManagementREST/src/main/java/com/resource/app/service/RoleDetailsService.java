package com.resource.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.app.model.ResourceDetails;
import com.resource.app.model.RoleDetails;
import com.resource.app.repository.iRoleDetailsRepo;

@Service
public class RoleDetailsService implements iRoleDetailsService{
	
	@Autowired
	private iRoleDetailsRepo roleDetailsRepo;

	@Transactional
	@Override
	public RoleDetails addRoleDetails(RoleDetails roleDetails) {
		
		return roleDetailsRepo.save(roleDetails);
	}

	@Override
	public List<RoleDetails> listRoleDetails() {
		
		return roleDetailsRepo.findAll();
	}

	@Override
	public RoleDetails findByRoleId(Integer roleId) {
		Optional<RoleDetails> findRoleId=roleDetailsRepo.findById(roleId);
		RoleDetails roleDetails=findRoleId.isPresent()? findRoleId.get():null;
		return roleDetails;
	}

}
