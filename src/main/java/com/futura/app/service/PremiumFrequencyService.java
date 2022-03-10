package com.futura.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.PremiumFrequency;
import com.futura.app.repository.PremiumFrequencyRepository;



@Service
public class PremiumFrequencyService {

	@Autowired
	private PremiumFrequencyRepository premiumFrequencyRepository;

	public PremiumFrequency getPremiumFrequencyByFrequencyDesc(String frequencyDesc) {
		return premiumFrequencyRepository.findByFrequencyTerm(frequencyDesc);
	}
	
	public List<PremiumFrequency> getAllPremiumFrequency()
	{
		return premiumFrequencyRepository.findAll();
	}

	public PremiumFrequency addPremiumFrequency(PremiumFrequency premiumFrequency) {
		return premiumFrequencyRepository.save(premiumFrequency);
	}

	public PremiumFrequency updatePremiumFrequency(PremiumFrequency premiumFrequency,Long Id) {
		PremiumFrequency frequencyAlt = premiumFrequencyRepository.findById(Id).get();
		if(premiumFrequency.getFrequencyTerm()!=null)
		{
			frequencyAlt.setFrequencyTerm(premiumFrequency.getFrequencyTerm());
		}
		return premiumFrequencyRepository.save(frequencyAlt);
	}

	public ResponseEntity<String> deletepremiumFrequency(Long Id) {
		try {
			premiumFrequencyRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
}

