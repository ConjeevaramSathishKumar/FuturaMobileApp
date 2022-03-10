package com.futura.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.Country;
import com.futura.app.repository.CountryRepository;



@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public Country getCountryByName(String countryFullName) {
		return countryRepository.findBycountryFullName(countryFullName);
	}
	
	public List<Country> getAllCountry()
	{
		return countryRepository.findAll();
	}

	public Country addCountry(Country country) {
		return countryRepository.save(country);
	}

	public Country updateCountry(Country country,Long Id) 
	{
		Country countryAlt = countryRepository.findById(Id).get();
		if(country.getCountryFullName()!=null)
		{
			countryAlt.setCountryFullName(country.getCountryFullName());
		}
		return countryRepository.save(countryAlt);
	}


	public ResponseEntity<String> deleteCountry(Long Id) {
		try {
			countryRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}


}