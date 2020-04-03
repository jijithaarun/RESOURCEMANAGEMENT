package com.resource.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.resource.app.model.ResourceDetails;

public interface iResourceDetailsRepo extends JpaRepositoryImplementation<ResourceDetails, Long> {

	@Query("from ResourceDetails order by resourceId desc")
	List<ResourceDetails> listAllResource();
	
	@Query("from ResourceDetails where isActive='Y'")
	List<ResourceDetails> listResourcedetails();

	@Query("from ResourceDetails WHERE resource.resourceType=?1")
	List<ResourceDetails> findByResource(String resourceName);
	
	@Query("from ResourceDetails where resourceId=?1")
	Optional<ResourceDetails> findImage(String imageName);

	@Modifying
	@Query("update ResourceDetails set isActive=?1 where resourceId=?2")
	void save(Character isActive,Long resourceId);
	
	@Modifying
	@Query("update ResourceDetails set isBooked=?1 where resourceId=?2")
	void saveIsBooked(Character isBooked,Long resourceId);


	@Modifying
	@Query("update ResourceDetails set isAccepted=?1 where resourceId=?2")
	void saveIsAccepted(Character isAccepted,Long resourceId);
}
