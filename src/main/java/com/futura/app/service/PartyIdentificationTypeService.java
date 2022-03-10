package com.futura.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.PartyIdentificationType;
import com.futura.app.repository.PartyIdentificationTypeRepository;



@Service
public class PartyIdentificationTypeService {

	@Autowired
	private PartyIdentificationTypeRepository partyIdentificationTypeRepository;

	public PartyIdentificationType getPartyIdentificationTypeByPartyIdType(String partyIdType)
	{
		return partyIdentificationTypeRepository.findByPartyIdType(partyIdType);
	}
	
	public List<PartyIdentificationType> getAllPartyIdentificationType()
	{
		return partyIdentificationTypeRepository.findAll();
	}

	public PartyIdentificationType addPartyIdentificationType(PartyIdentificationType partyIdentificationType) 
	{
		return partyIdentificationTypeRepository.save(partyIdentificationType);
	}

	public PartyIdentificationType updatePartyIdentificationType(PartyIdentificationType partyIdentificationType,Long Id) 
	{
		PartyIdentificationType partyIdTypeAlt = partyIdentificationTypeRepository.findById(Id).get();
		if(partyIdentificationType.getPartyIdType()!=null)
		{
			partyIdTypeAlt.setPartyIdType(partyIdentificationType.getPartyIdType());
		}
		return partyIdentificationTypeRepository.save(partyIdTypeAlt);
	}

	public ResponseEntity<String> deletePartyIdentificationType(Long Id) {
		try {
			partyIdentificationTypeRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}

	public PartyIdentificationType getPolicyAlterationByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
