package org.example.lab9.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab9.dto.auth.LoginRequest;
import org.example.lab9.dto.auth.LoginResponse;
import org.example.lab9.dto.auth.RefreshTokenRequest;
import org.example.lab9.dto.auth.RefreshTokenResponse;
import org.example.lab9.entity.Patient;
import org.example.lab9.repo.PatientRepository;
import org.example.lab9.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.lab9.JWTUtil;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    final private PatientRepository patientRepository;
    final private PasswordEncoder passwordEncoder;
    final private JWTUtil jwtUtil;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Patient patient = patientRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("Patient not found"));
        if(passwordEncoder.matches(loginRequest.getPassword(), patient.getPassword())){
        String accessToken  = jwtUtil.generateAccessToken(patient);
        String refreshToken = jwtUtil.generateRefreshToken(patient);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setAccessToken(accessToken);
        loginResponse.setRefreshToken(refreshToken);
        loginResponse.setEmail(patient.getEmail());
        loginResponse.setFirstName(patient.getFirstName());
        loginResponse.setLastName(patient.getLastName());
        loginResponse.setRole(patient.getRole());
        return loginResponse;
        }

        throw new RuntimeException("Invalid password");

    }

    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {

        String email = jwtUtil.extractUsername(refreshTokenRequest.getRefreshToken());
        Patient patient = patientRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Patient not found"));
        if(jwtUtil.validateRefreshToken(refreshTokenRequest.getRefreshToken(), new UserDetailsImpl(patient))){
            String accessToken = jwtUtil.generateAccessToken(patient);
            RefreshTokenResponse refreshTokenResponse = new RefreshTokenResponse();
            refreshTokenResponse.setAccessToken(accessToken);
            refreshTokenResponse.setRefreshToken(refreshTokenRequest.getRefreshToken());
            return refreshTokenResponse;
        }
        throw new RuntimeException("Invalid token");


    }
}
