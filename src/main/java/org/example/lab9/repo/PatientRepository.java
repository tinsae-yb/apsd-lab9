package org.example.lab9.repo;

import org.example.lab9.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    @Query("SELECT p FROM Patient p WHERE p.firstName LIKE %?1% OR p.lastName LIKE %?1% OR p.email LIKE %?1% OR p.phone LIKE %?1%")
    List<Patient> findAllByAny(String searchString);


    Optional<Patient> findByEmail(String email);
}
