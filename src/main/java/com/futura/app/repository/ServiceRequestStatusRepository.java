package com.futura.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futura.app.entity.ServiceRequestStatus;

@Repository
public interface ServiceRequestStatusRepository extends JpaRepository<ServiceRequestStatus, Long> {

	ServiceRequestStatus findByServiceStatusName(String srStatusDesc);
		





}
