package org.example.lab9.service;


import org.example.lab9.dto.patient.PatientListResponse;
import org.example.lab9.dto.patient.PatientResponse;
import org.example.lab9.dto.patient.PatientRequest;

public interface PatientService {
    PatientListResponse getAllPatients();

    PatientResponse getPatientById(Long id);

    PatientResponse registerPatient(PatientRequest patientDTO);

    PatientResponse updatePatient(PatientRequest patientRequest, Long id);

    void deletePatient(Long id);

    PatientListResponse searchPatient(String searchString);
//    List<PatientWithAddressDTO> getAllPatients();
//
//    PatientWithAddressDTO getPatientById(Long id);
//
//    PatientWithAddressDTO registerPatient(PatientWithAddressDTO patientDTO);
//
//    PatientWithAddressDTO updatePatient(PatientWithOutAddressDTO patientDTO, Long id);
//    void deletePatient(Long id);
//
//    List<PatientWithAddressDTO> searchPatient(String search);


}
