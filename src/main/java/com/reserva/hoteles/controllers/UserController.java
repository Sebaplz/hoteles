package com.reserva.hoteles.controllers;

import com.reserva.hoteles.controllers.models.AuthResponse;
import com.reserva.hoteles.controllers.models.AuthenticationRequest;
import com.reserva.hoteles.controllers.models.RegisterRequest;
import com.reserva.hoteles.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "${CORS_ORIGIN}")
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
