package org.example.lab9.repo;


import org.example.lab9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("SELECT DISTINCT u FROM User u WHERE u.email = :username")
    Optional<User> findByEmail(String username);

//
//    @Query("SELECT DISTINCT p FROM Patient p LEFT JOIN Address a ON p.mailingAddress.id = a.id ORDER BY p.lastName ASC")
//    List<Patient> getAllPatientsSortedByLastNameASC();
//
//    @Query("SELECT DISTINCT p FROM Patient p WHERE p.id = :id")
//    Optional<Patient> findPatientById(@Param("id") Long id);
//
//    @Query("SELECT DISTINCT p FROM Patient p WHERE p.firstName LIKE %:search% OR p.lastName LIKE %:search% OR p.patientNo LIKE %:search% OR  p.email LIKE %:search% OR p.phone LIKE %:search% OR   p.mailingAddress.city LIKE %:search% OR p.mailingAddress.state LIKE %:search% OR p.mailingAddress.addressOne LIKE %:search%")
//    List<Patient> searchPatientByAllFields(@Param("search") String search);
//
//    @Query("SELECT DISTINCT u FROM User u WHERE u.email = :username")
//    Optional<User> findByEmail(String username);
}
