package com.futura.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.PolicyAlteration;
import com.futura.app.repository.PolicyAlterationRepository;



@Service
public class PolicyAlterationService {

	@Autowired
	private PolicyAlterationRepository policyAlterationRepository;

	public PolicyAlteration getPolicyAlterationByName(String alterationName) {
		return policyAlterationRepository.findByAlterationName(alterationName);
	}
	
	public List<PolicyAlteration> getAllPolicyAlterations()
	{
		return policyAlterationRepository.findAll();
	}

	public PolicyAlteration addPolicyAlteration(PolicyAlteration policyAlteration) {
		return policyAlterationRepository.save(policyAlteration);
	}

	public PolicyAlteration updatePolicyAlteration(PolicyAlteration policyAlteration,Long alterationId)
	{
		PolicyAlteration policyAlt = policyAlterationRepository.findById(alterationId).get();
		if(policyAlteration.getAlterationName()!=null)
		{
			policyAlt.setAlterationName(policyAlteration.getAlterationName());
		}
		return policyAlterationRepository.save(policyAlt);
	}

	public ResponseEntity<String> deletePolicyAlteration(Long alterationId) {
		try {
			policyAlterationRepository.deleteById(alterationId);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
}
