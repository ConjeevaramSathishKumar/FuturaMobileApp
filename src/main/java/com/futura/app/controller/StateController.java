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

import com.futura.app.entity.State;
import com.futura.app.service.StateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class StateController {

	@Autowired
    private StateService stateService;

    @PostMapping(path = "addState")
    public State addState(@RequestBody State state) {
        return stateService.addState(state);
    }

    @GetMapping(path = "getAllState")
    public List<State> getAllState() {
        return stateService.getAllState();
    }
    
    @GetMapping(path = "getAllState/{name}")
    public State getAllState(@PathVariable String stateName) {
        return stateService.getStateByStateName(stateName);
    }
    
    @PatchMapping(path = "updateState/{Id}")
    public State updateState(@PathVariable Long Id,@RequestBody State state) {
        return stateService.updateState(state,Id);
    }
    
    @DeleteMapping(path = "deletestate/{Id}")
    public ResponseEntity<String> deleteState(@PathVariable Long Id) {
        return stateService.deleteState(Id);
    }

}



