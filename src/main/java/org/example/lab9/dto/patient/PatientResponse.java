package org.example.lab9.dto.patient;

import lombok.Data;
import org.example.lab9.dto.address.AddressResponse;
import org.example.lab9.entity.Patient;
import org.example.lab9.entity.User;

import java.time.LocalDate;

@Data
public class PatientResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private User.RoleType role;
    private AddressResponse mailingAddress;
    private LocalDate dateOfBirth;
    private String patientNo;
    static public PatientResponse fromPatient(Patient patient){
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setFirstName(patient.getFirstName());
        patientResponse.setLastName(patient.getLastName());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setPhone(patient.getPhone());
        patientResponse.setRole(patient.getRole());
        patientResponse.setMailingAddress(AddressResponse.fromAddress(patient.getMailingAddress()));
        patientResponse.setDateOfBirth(patient.getDateOfBirth());
        patientResponse.setPatientNo(patient.getPatientNo());
        return patientResponse;
    }
}
