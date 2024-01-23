package com.reserva.hoteles.service;

import com.reserva.hoteles.Dto.AuthResponse;
import com.reserva.hoteles.Dto.AuthenticationRequest;
import com.reserva.hoteles.Dto.RegisterRequest;

public interface AuthService {
    AuthResponse register (RegisterRequest request);
    AuthResponse authenticate (AuthenticationRequest request);
}
