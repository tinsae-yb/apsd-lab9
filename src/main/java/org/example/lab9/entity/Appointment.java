package org.example.lab9.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Appointment {

    @Id
    @GeneratedValue()
    private Long id;
    private LocalDateTime appointmentDateTime;
    @ManyToOne()
    private Dentist dentist;
    @ManyToOne()
    private Patient patient;
    @ManyToOne()
    private Surgery surgery;


}
