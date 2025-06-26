package com.sunshine.sunspring.controller;

import com.sunshine.sunspring.model.AuthRequest;
import com.sunshine.sunspring.model.AuthResponse;
import com.sunshine.sunspring.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authenticationService.authenticate(authRequest.getEmail(), authRequest.getPassword());
    }
}
