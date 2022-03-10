package com.futura.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futura.app.entity.ServiceRequestStatus;
import com.futura.app.service.ServiceRequestStatusService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class ServiceRequestStatusController {

	@Autowired
    private ServiceRequestStatusService serviceRequestStatusService;

    @PostMapping(path = "addServiceRequestStatus")
    public ServiceRequestStatus addServiceRequestStatus(@RequestBody ServiceRequestStatus serviceRequestStatus) {
        return serviceRequestStatusService.addServiceRequestStatus(serviceRequestStatus);
    }

    @GetMapping(path = "getAllServiceRequestStatus")
    public List<ServiceRequestStatus> getAllServiceRequestStatus() {
        return serviceRequestStatusService.getAllServiceRequestStatus();
    }
    
    @GetMapping(path = "getAllServiceRequestStatus/{srStatusDesc}")
    public ServiceRequestStatus getAllServiceRequestStatus(@PathVariable String srStatusDesc) {
        return serviceRequestStatusService.getServiceRequestStatusBySrStatusDesc(srStatusDesc);
    }
    
    @PatchMapping(path = "updateServiceRequestStatus/{Id}")
    public ServiceRequestStatus updateServiceRequestStatus(@PathVariable Long Id,@RequestBody ServiceRequestStatus serviceRequestStatus) {
        return serviceRequestStatusService.updateServiceRequestStatus(serviceRequestStatus,Id);
    }
    
    @DeleteMapping(path = "deleteserviceRequestStatus/{Id}")
    public ResponseEntity<String> deleteServiceRequestStatus(@PathVariable Long Id) {
        return serviceRequestStatusService.deleteserviceRequestStatus(Id);
    }

}






