package com.resource.app.model;

public class JwtResponse {

	private final String jwttoken;
	private String userName;
	private Integer roleId;

	public JwtResponse(String jwttoken, String userName, Integer roleId) {

		this.jwttoken = jwttoken;
		this.userName = userName;
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
