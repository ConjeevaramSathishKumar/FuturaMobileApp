package com.futura.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.UserType;
import com.futura.app.repository.UserTypeRepository;



@Service
public class UserTypeService {

	@Autowired
	private UserTypeRepository userTypeRepository;

	public UserType getUserTypeByName(String userTypeDescName) {
		return userTypeRepository.findByUserTypeDesc(userTypeDescName);
	}
	
	public List<UserType> getAllUserType()
	{
		return userTypeRepository.findAll();
	}

	public UserType addUserType(UserType userType) {
		return userTypeRepository.save(userType);
	}

	public UserType updateUserType(UserType userType,Long Id) {
		UserType userAlt = userTypeRepository.findById(Id).get();
		if(userType.getUserTypeDesc()!=null)
		{
			userAlt.setUserTypeDesc(userType.getUserTypeDesc());
		}
		return userTypeRepository.save(userAlt);
	}

	public ResponseEntity<String> deleteUserType(Long Id) {
		try {
			userTypeRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
}

