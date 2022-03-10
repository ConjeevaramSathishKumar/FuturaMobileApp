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

import com.futura.app.entity.PolicyAlteration;
import com.futura.app.service.PolicyAlterationService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

//@Api(value = "PolicyAlterationController", description = "REST APIs related to Policy Alteration Entity!")
@RestController
@RequestMapping(path = "app/api")
@AllArgsConstructor
public class PolicyAlterationController {

	@Autowired
    private PolicyAlterationService policyAlterationService;

    @PostMapping(path = "addPolicyAlteration")
    public PolicyAlteration addPolicyAlteration(@RequestBody PolicyAlteration policyAlteration) {
        return policyAlterationService.addPolicyAlteration(policyAlteration);
    }

    @GetMapping(path = "getAllPolicyAlteration")
    public List<PolicyAlteration> getAllPolicyAlteration() {
        return policyAlterationService.getAllPolicyAlterations();
    }
    
    @GetMapping(path = "getAllPolicyAlteration/{name}")
    public PolicyAlteration getAllPolicyAlteration(@PathVariable String name) {
        return policyAlterationService.getPolicyAlterationByName(name);
    }
    
    @PatchMapping(path = "updatePolicyAlteration/{alterationId}")
    public PolicyAlteration updatePolicyAlteration(@PathVariable Long alterationId,@RequestBody PolicyAlteration policyAlteration) {
        return policyAlterationService.updatePolicyAlteration(policyAlteration,alterationId);
    }
    
    @DeleteMapping(path = "deletePolicyAlteration/{alterationId}")
    public ResponseEntity<String> deletePolicyAlteration(@PathVariable Long alterationId) {
        return policyAlterationService.deletePolicyAlteration(alterationId);
    }

}
