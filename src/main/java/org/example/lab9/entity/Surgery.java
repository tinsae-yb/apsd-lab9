package org.example.lab9.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity

public class Surgery {
    @Id
    @GeneratedValue()
    private Long id;

    private String surgeryNo;

    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;

    private String surgeryName;


}
