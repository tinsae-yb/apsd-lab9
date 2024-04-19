package org.example.lab9.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Data
public class Patient extends User {
    @OneToOne
    private Address mailingAddress;
    private LocalDate dateOfBirth;
    private String patientNo;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE , orphanRemoval = true)
    private List<Appointment> appointments;


}
