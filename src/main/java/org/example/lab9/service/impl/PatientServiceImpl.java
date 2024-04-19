package org.example.lab9.service.impl;


import lombok.AllArgsConstructor;
import org.example.lab9.dto.patient.PatientListResponse;
import org.example.lab9.dto.patient.PatientRequest;
import org.example.lab9.dto.patient.PatientResponse;
import org.example.lab9.entity.Address;
import org.example.lab9.entity.Patient;
import org.example.lab9.repo.AddressRepository;
import org.example.lab9.repo.PatientRepository;
import org.example.lab9.service.PatientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public PatientListResponse getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return PatientListResponse.from(patients);
    }

    @Override
    public PatientResponse getPatientById(Long id) {

        return patientRepository.findById(id).map(PatientResponse::fromPatient).orElseThrow(
                () -> new RuntimeException("Patient not found with id: " + id)
        );

    }

    @Override
    public PatientResponse registerPatient(PatientRequest patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhone(patientDTO.getPhone());
        patient.setRole(patientDTO.getRole()    );
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setPatientNo(patientDTO.getPatientNo());
        patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        Address address = new Address();
        address.setAddressOne(patientDTO.getMailingAddress().getAddressOne());
        address.setCity(patientDTO.getMailingAddress().getCity());
        address.setState(patientDTO.getMailingAddress().getState());
        addressRepository.save(address);
        patient.setMailingAddress(address);
        patientRepository.save(patient);
        return PatientResponse.fromPatient(patient);
    }

    @Override
    public PatientResponse updatePatient(PatientRequest patientRequest, Long id) {

        return patientRepository.findById(id).map(patient -> {
            patient.setFirstName(patientRequest.getFirstName());
            patient.setLastName(patientRequest.getLastName());
            patient.setEmail(patientRequest.getEmail());
            patient.setPhone(patientRequest.getPhone());
            patient.setDateOfBirth(patientRequest.getDateOfBirth());
            patient.setPatientNo(patientRequest.getPatientNo());
            if (patient.getMailingAddress() != null) {
                addressRepository.delete(patient.getMailingAddress());
                Address address = new Address();
                address.setAddressOne(patientRequest.getMailingAddress().getAddressOne());
                address.setCity(patientRequest.getMailingAddress().getCity());
                address.setState(patientRequest.getMailingAddress().getState());
                addressRepository.save(address);
                patient.setMailingAddress(address);
            }
            patientRepository.save(patient);
            return PatientResponse.fromPatient(patient);
        }).orElseThrow(
                () -> new RuntimeException("Patient not found with id: " + id)
        );
    }

    @Override
    public void deletePatient(Long id) {

        patientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Patient not found with id: " + id)
        );
        patientRepository.deleteById(id);

    }

    @Override
    public PatientListResponse searchPatient(String searchString) {
        List<Patient> patients = patientRepository.findAllByAny(searchString);
        return PatientListResponse.from(patients);

    }



}
