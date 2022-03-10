package com.futura.app.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.futura.app.model.RegistrationRequest;
import com.futura.app.service.RegistrationService;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
