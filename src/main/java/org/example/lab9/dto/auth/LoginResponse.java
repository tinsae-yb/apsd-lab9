package org.example.lab9.dto.auth;

import lombok.Data;
import org.example.lab9.entity.User;

@Data
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private User.RoleType role;
    private String email;
    private String firstName;
    private String lastName;
}
