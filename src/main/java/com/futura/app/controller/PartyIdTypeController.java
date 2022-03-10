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

import com.futura.app.entity.PartyIdentificationType;
import com.futura.app.service.PartyIdentificationTypeService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

//@Api(value = "PartyIdentificationTypeController", description = "REST APIs related to Party Identification Type!")
@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class PartyIdTypeController {

	@Autowired
    private PartyIdentificationTypeService partyIdentificationTypeService;

    @PostMapping(path = "addPartyIdentificationType")
    public PartyIdentificationType addPartyIdentificationType(@RequestBody PartyIdentificationType partyIdentificationType) {
        return partyIdentificationTypeService.addPartyIdentificationType(partyIdentificationType);
    }

    @GetMapping(path = "getAllPartyIdentificationType")
    public List<PartyIdentificationType> getAllPartyIdentificationType() {
        return partyIdentificationTypeService.getAllPartyIdentificationType();
    }
    
    @GetMapping(path = "getAllPartyIdentificationType/{name}")
    public PartyIdentificationType getAllPartyIdentificationType(@PathVariable String name) {
        return partyIdentificationTypeService.getPartyIdentificationTypeByPartyIdType(name);
    }
    
    @PatchMapping(path = "updatePartyIdentificationType/{Id}")
    public PartyIdentificationType updatePartyIdentificationType(@PathVariable Long Id,@RequestBody PartyIdentificationType partyIdentificationType) 
    {
        return partyIdentificationTypeService.updatePartyIdentificationType(partyIdentificationType,Id);
    }
    
    @DeleteMapping(path = "deletePartyIdentificationType/{Id}")
    public ResponseEntity<String> deletePartyIdentificationType(@PathVariable Long Id) {
        return partyIdentificationTypeService.deletePartyIdentificationType(Id);
    }

}
