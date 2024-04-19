package org.example.lab9.controller;


import lombok.AllArgsConstructor;
import org.example.lab9.dto.auth.LoginRequest;
import org.example.lab9.dto.auth.LoginResponse;
import org.example.lab9.dto.auth.RefreshTokenRequest;
import org.example.lab9.dto.auth.RefreshTokenResponse;
import org.example.lab9.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adsweb/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/refreshToken")
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){

        return authService.refreshToken(refreshTokenRequest);
    }
}
