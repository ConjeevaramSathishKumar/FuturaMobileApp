package com.futura.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.UserRoles;
import com.futura.app.repository.UserRolesRepository;



@Service
public class UserRolesService {

	@Autowired
	private UserRolesRepository userRolesRepository;

	public UserRoles getUserRolesByUserId(Long userId) {
		return userRolesRepository.findByUserId(userId);
	}
	
	public List<UserRoles> getAllUserRoles()
	{
		return userRolesRepository.findAll();
	}

	public UserRoles addUserType(UserRoles userRoles) {
		return userRolesRepository.save(userRoles);
	}

	public UserRoles updateUserRoles(UserRoles userRoles,Long Id) {
		UserRoles userAlt = userRolesRepository.findById(Id).get();
		if(userRoles.getUserId()!=null)
		{
			userAlt.setUserId(userRoles.getUserId());
		}
		return userRolesRepository.save(userAlt);
		
	}

	public ResponseEntity<String> deleteUserType(Long Id) {
		try {
			userRolesRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
}

