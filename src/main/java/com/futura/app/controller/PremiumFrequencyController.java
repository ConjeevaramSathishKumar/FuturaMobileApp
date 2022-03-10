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

import com.futura.app.entity.PremiumFrequency;
import com.futura.app.service.PremiumFrequencyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class PremiumFrequencyController {

	@Autowired
    private PremiumFrequencyService premiumFrequencyService;

    @PostMapping(path = "addPremiumFrequency")
    public PremiumFrequency addPremiumFrequency(@RequestBody PremiumFrequency premiumFrequency) {
        return premiumFrequencyService.addPremiumFrequency(premiumFrequency);
    }

    @GetMapping(path = "getAllPremiumFrequency")
    public List<PremiumFrequency> getAllPremiumFrequency() {
        return premiumFrequencyService.getAllPremiumFrequency();
    }
    
    @GetMapping(path = "getAllPremiumFrequency/{name}")
    public PremiumFrequency getAllPremiumFrequency(@PathVariable String frequencyDesc) {
        return premiumFrequencyService.getPremiumFrequencyByFrequencyDesc(frequencyDesc);
    }
    
    @PatchMapping(path = "updatePremiumFrequency/{Id}")
    public PremiumFrequency updatePremiumFrequency(@PathVariable Long Id,@RequestBody PremiumFrequency premiumFrequency) {
        return premiumFrequencyService.updatePremiumFrequency(premiumFrequency,Id);
    }
    
    @DeleteMapping(path = "deletePremiumFrequency/{Id}")
    public ResponseEntity<String> deletePremiumFrequency(@PathVariable Long Id) {
        return premiumFrequencyService.deletepremiumFrequency(Id);
    }

}



