package org.example.lab9.service;

import org.example.lab9.dto.auth.LoginRequest;
import org.example.lab9.dto.auth.LoginResponse;
import org.example.lab9.dto.auth.RefreshTokenRequest;
import org.example.lab9.dto.auth.RefreshTokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
