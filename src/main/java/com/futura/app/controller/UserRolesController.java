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

import com.futura.app.entity.UserRoles;
import com.futura.app.service.UserRolesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor

public class UserRolesController {

	@Autowired
    private UserRolesService userRolesService;

	
    @PostMapping(path = "addUserRoles")
    public UserRoles addUserRoles(@RequestBody UserRoles userRoles) {
        return userRolesService.addUserType(userRoles);
    }

    @GetMapping(path = "getAllUserRoles")
    public List<UserRoles> getAllUserRoles() {
        return userRolesService.getAllUserRoles();
    }
    
    @GetMapping(path = "getAllUserRoles/{userId}")
    public UserRoles getAllUserRoles(@PathVariable Long userId) {
        return userRolesService.getUserRolesByUserId(userId);
    }
    
    @PatchMapping(path = "updateUserRoles/{Id}")
    public UserRoles updateUserRoles(@PathVariable Long Id,@RequestBody UserRoles userRoles) {
        return userRolesService.updateUserRoles(userRoles,Id);
    }
    
    @DeleteMapping(path = "deleteUserRoles/{Id}")
    public ResponseEntity<String> deleteUserRoles(@PathVariable Long Id) {
        return userRolesService.deleteUserType(Id);
    }



}
