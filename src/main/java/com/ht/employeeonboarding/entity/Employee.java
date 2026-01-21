package com.ht.employeeonboarding.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String employeeName;
	private String employeeMobile;
	private String employeeDesignation;
	private String department;
	private String email;
	
	
    @Enumerated(EnumType.STRING) // Store as String
	private Gender gender ;
	
	
	// One-to-Many with EmployeeAddress
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<EmployeeAddress> employeeAddresses;

	// One-to-Many with EmployeeSkills (Assuming an employee has multiple skills)
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmployeeSkills > employeeSkills; // ✅ Changed to `List<>`

	// One-to-Many with EmployeeQualification (Corrected plural name)
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmployeeQualification> employeeQualifications; // ✅ Changed to plural

	// One-to-Many with EmployeeTechCertifications (Must be a collection)
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EmployeeTechCertifications> employeeTechCertifications; // ✅ Changed to List

	// One-to-One with EmployeePersonalData (Correct)
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
	private EmployeePersonalData employeePersonnelData;

}
