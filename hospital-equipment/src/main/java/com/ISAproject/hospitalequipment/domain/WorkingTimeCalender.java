package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="WorkingTimeCalenders")
@Getter
@Setter
public class WorkingTimeCalender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @OneToMany(mappedBy = "workingTimeCalender", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
