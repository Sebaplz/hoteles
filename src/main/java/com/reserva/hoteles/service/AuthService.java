package com.reserva.hoteles.service;

import com.reserva.hoteles.controllers.models.AuthResponse;
import com.reserva.hoteles.controllers.models.AuthenticationRequest;
import com.reserva.hoteles.controllers.models.RegisterRequest;

public interface AuthService {
    AuthResponse register (RegisterRequest request);
    AuthResponse authenticate (AuthenticationRequest request);
}
