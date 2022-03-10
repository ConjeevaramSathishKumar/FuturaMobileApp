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

import com.futura.app.entity.UserType;
import com.futura.app.service.UserTypeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor

public class UserTypeController {

	@Autowired
    private UserTypeService userTypeService;

    @PostMapping(path = "addUserType")
    public UserType addUserType(@RequestBody UserType userType) {
        return userTypeService.addUserType(userType);
    }

    @GetMapping(path = "getAllUserType")
    public List<UserType> getAllUserType() {
        return userTypeService.getAllUserType();
    }
    
    @GetMapping(path = "getAllUserType/{userTypeDesc}")
    public UserType getAllUserType(@PathVariable String userTypeDesc) {
        return userTypeService.getUserTypeByName(userTypeDesc);
    }
    
    @PatchMapping(path = "updateUserType/{Id}")
    public UserType updateUserType(@PathVariable Long Id,@RequestBody UserType userType) {
        return userTypeService.updateUserType(userType,Id);
    }
    
    @DeleteMapping(path = "deleteUserType/{Id}")
    public ResponseEntity<String> deleteUserType(@PathVariable Long Id) {
        return userTypeService.deleteUserType(Id);
    }



}
