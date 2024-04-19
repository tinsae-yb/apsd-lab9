package org.example.lab9.controller;


import lombok.AllArgsConstructor;
import org.example.lab9.dto.patient.PatientListResponse;
import org.example.lab9.dto.patient.PatientResponse;
import org.example.lab9.dto.patient.PatientRequest;
import org.example.lab9.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/list")
    public PatientListResponse getPatients(){
       return patientService.getAllPatients();
    }
    @GetMapping("/get/{id}")
    public PatientResponse getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @PostMapping("/register")
    public PatientResponse registerPatient(@RequestBody PatientRequest patientDTO){
        return patientService.registerPatient(patientDTO);
    }

    @PutMapping("/update/{id}")
    public PatientResponse updatePatient(@RequestBody PatientRequest patientRequest, @PathVariable Long id){
        return patientService.updatePatient(patientRequest, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable Long id){
         patientService.deletePatient(id);
    }

    @GetMapping("/search/{search_string}")
    public PatientListResponse searchPatient(@PathVariable(value = "search_string") String searchString){
        System.out.println("searchString = " + searchString);
        return patientService.searchPatient(searchString);
    }


}
