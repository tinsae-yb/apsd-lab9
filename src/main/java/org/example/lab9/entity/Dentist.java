package org.example.lab9.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Entity
public class Dentist  extends User {

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;
    private String specialization;
}
