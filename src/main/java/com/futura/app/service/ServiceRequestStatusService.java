package com.futura.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.ServiceRequestStatus;
import com.futura.app.repository.ServiceRequestStatusRepository;



@Service
public class ServiceRequestStatusService {

	@Autowired
	private ServiceRequestStatusRepository serviceRequestStatusRepository;

	public ServiceRequestStatus getServiceRequestStatusBySrStatusDesc(String srStatusDesc) {
		return serviceRequestStatusRepository.findByServiceStatusName(srStatusDesc);
	}
	
	public List<ServiceRequestStatus> getAllServiceRequestStatus()
	{
		return serviceRequestStatusRepository.findAll();
	}

	public ServiceRequestStatus addServiceRequestStatus(ServiceRequestStatus serviceRequestStatus) {
		return serviceRequestStatusRepository.save(serviceRequestStatus);
	}

	public ServiceRequestStatus updateServiceRequestStatus(ServiceRequestStatus serviceRequestStatus,Long Id) {
		ServiceRequestStatus serviceAlt = serviceRequestStatusRepository.findById(Id).get();
		if(serviceRequestStatus.getServiceStatusName()!=null)
		{
		   serviceAlt.setServiceStatusName(serviceRequestStatus.getServiceStatusName());
		}
		return serviceRequestStatusRepository.save(serviceAlt);
	}

	public ResponseEntity<String> deleteserviceRequestStatus(Long Id) {
		try {
			serviceRequestStatusRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
}
