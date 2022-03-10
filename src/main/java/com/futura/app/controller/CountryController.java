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

import com.futura.app.entity.Country;
import com.futura.app.service.CountryService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Api(value = "CountryController", description = "REST APIs related to Country Entity!")
@Slf4j
@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class CountryController {

	@Autowired
    private CountryService countryService;

    @PostMapping(path = "addCountry")
    public Country addCountry(@RequestBody Country country) 
    {
    	log.info("addCountry: {}", country.toString());
        return countryService.addCountry(country);
    }

    @GetMapping(path = "getAllcountry")
    public List<Country> getAllCountry() {
    	log.info("getAllCountry: {}");
        return countryService.getAllCountry();
    }
    
    @GetMapping(path = "getAllCountry/{countryFullName}")
    public Country getCountryByName(@PathVariable String countryFullName) {
    	log.info("getCountryByName for : {}",countryFullName);
        return countryService.getCountryByName(countryFullName);
    }
    
    @PatchMapping(path = "updateCountry/{Id}")
    public Country updateCountry(@PathVariable Long Id,@RequestBody Country country) {
    	log.info("updateCountry for : {}",country.toString());
        return countryService.updateCountry(country,Id);
    }
    
    @DeleteMapping(path = "deleteCountry/{Id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long Id) {
    	log.info("deleteCountry with id : {}",Id);
        return countryService.deleteCountry(Id);
    }





}
