package com.ht.employeeonboarding.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

@Table(name = "employee_personal_data")
public class EmployeePersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT") // Storing as Base64 String
    private String resume; // Stores resume as a Base64 string (PDF)

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String aadharCard; // Stores Aadhar card image as Base64

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String panCard; // Stores PAN card image as Base64

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String passportPhoto; // Stores passport-size photo as Base64

//  @JsonBackReference  // 🔹 Prevent infinite loop
    @OneToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonIgnore  // ✅ Prevent infinite recursion
    private Employee employee;
}
