package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="CompanyProfiles")
public class CompanyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String Name;
    public String Adress;
    public String Description;
    public Double Grade;
    // dodati public List<Appointment> Appointments;
    // dodati spisak administratora kompanije


    public CompanyProfile(String name, String adress, String description, Double grade) {
        Name = name;
        Adress = adress;
        Description = description;
        Grade = grade;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public String getAdress() {
        return Adress;
    }

    public String getDescription() {
        return Description;
    }

    public Double getGrade() {
        return Grade;
    }

    /*
    public List<Appointment> getAppointments() {
        return Appointments;
    }
    */
    public void setName(String name) {
        Name = name;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setGrade(Double grade) {
        Grade = grade;
    }

    /*
    public void setAppointments(List<Appointment> appointments) {
        Appointments = appointments;
    }
    */
}
