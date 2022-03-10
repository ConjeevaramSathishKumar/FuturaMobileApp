package com.futura.app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.PartyType;
import com.futura.app.repository.PartyTypeRepository;



@Service
public class PartyTypeService {

	@Autowired
	private PartyTypeRepository partyTypeRepository;

	public PartyType getPartyTypeBypartytypedesc(String partyTypeDescName) {
		return partyTypeRepository.findByPartyTypeDesc(partyTypeDescName);
	}
	
	public List<PartyType> getAllPartyType()
	{
		return partyTypeRepository.findAll();
	}

	public PartyType addPartyType(PartyType partyType) {
		return partyTypeRepository.save(partyType);
	}

	public PartyType updatePartyType(PartyType partyType,Long Id) {
		PartyType partyAlt = partyTypeRepository.findById(Id).get();
		if(partyType.getPartyTypeDesc()!=null)
		{
			partyAlt.setPartyTypeDesc(partyType.getPartyTypeDesc());
		}
		return partyTypeRepository.save(partyAlt);
	}

	public ResponseEntity<String> deleteUserType(Long Id) {
		try {
			partyTypeRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}

	public ResponseEntity<String> deletePartyIdentificationType(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<String> addPartyType(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
