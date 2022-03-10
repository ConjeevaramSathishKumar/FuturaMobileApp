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

import com.futura.app.entity.PartyType;
import com.futura.app.service.PartyTypeService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

//@Api(value = "PartyTypeController", description = "REST APIs related to Party-Type Entity!")
@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class PartyTypeController {

	@Autowired
    private PartyTypeService partyTypeService;

    @PostMapping(path = "addPartyType")
    public PartyType addPartyType(@RequestBody PartyType partyType) {
        return partyTypeService.addPartyType(partyType);
    }

    @GetMapping(path = "getAllPartyType")
    public List<PartyType> getAllPartyType() {
        return partyTypeService.getAllPartyType();
    }
    
    @GetMapping(path = "getAllPartyType/{name}")
    public PartyType getAllPartyType(@PathVariable String name) {
        return partyTypeService.getPartyTypeBypartytypedesc(name);
    }
    
    @PatchMapping(path = "updatePartyType/{Id}")
    public PartyType updatePartyType(@PathVariable Long Id,@RequestBody PartyType partyType) 
    {
        return partyTypeService.updatePartyType(partyType,Id);
    }
    
    @DeleteMapping(path = "deletePartyType/{Id}")
    public ResponseEntity<String> deletePartyType(@PathVariable Long Id) {
        return partyTypeService.addPartyType(Id);
    }

}
