package com.resource.app.service;

import java.util.List;

import com.resource.app.model.Shortlisted;

public interface iShortlistedService {

	public Shortlisted addShortlisted(Shortlisted shortlisted);

	public List<Shortlisted> listShortlisted();

}
