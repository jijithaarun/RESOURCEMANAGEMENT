package com.resource.app.service;

import java.util.List;

import com.resource.app.model.RoleDetails;

public interface iRoleDetailsService {

	public RoleDetails addRoleDetails(RoleDetails roleDetails);

	public List<RoleDetails> listRoleDetails();

	public RoleDetails findByRoleId(Integer roleId);
	

}
