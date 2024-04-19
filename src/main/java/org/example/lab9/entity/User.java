package org.example.lab9.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class User {
    @Id
    @GeneratedValue()
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    private RoleType role;


    public enum RoleType {
        OfficeManager, DENTIST, PATIENT
    }

}
