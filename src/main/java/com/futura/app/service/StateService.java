package com.futura.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.futura.app.entity.State;
import com.futura.app.repository.StateRepository;



@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public State getStateByStateName(String stateName) {
		return stateRepository.findByStateName(stateName);
	}
	
	public List<State> getAllState()
	{
		return stateRepository.findAll();
	}

	public State addState(State state) {
		return stateRepository.save(state);
	}

	public State updateState(State state,Long Id) {
		State stateAlt = stateRepository.findById(Id).get();
		if(state.getStateName()!=null)
		{
		   stateAlt.setStateName(state.getStateName());
		}
		return stateRepository.save(stateAlt);
	}

	public ResponseEntity<String> deleteState(Long Id) {
		try {
			stateRepository.deleteById(Id);
		} catch (Exception e) {
			return new ResponseEntity<>("Error while deleting, pls try later", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
	}
}
