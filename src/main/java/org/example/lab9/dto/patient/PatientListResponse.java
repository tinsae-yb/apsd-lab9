package org.example.lab9.dto.patient;

import lombok.Data;
import org.example.lab9.dto.address.AddressResponse;
import org.example.lab9.entity.Patient;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatientListResponse {
    List<PatientResponse> patients = new ArrayList<>();

    public static PatientListResponse from(List<Patient> patients) {
        PatientListResponse response = new PatientListResponse();
        for (Patient patient : patients) {
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
            response.patients.add(patientResponse);
        }
        return response;
    }
}
