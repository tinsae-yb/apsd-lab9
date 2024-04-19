package org.example.lab9.dto.patient;

import lombok.Data;
import org.example.lab9.dto.address.NewAddressRequest;
import org.example.lab9.entity.User;

import java.time.LocalDate;

@Data
public class PatientRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private User.RoleType role;

    private NewAddressRequest mailingAddress;
    private LocalDate dateOfBirth;
    private String patientNo;

}
