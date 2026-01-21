package com.ht.employeeonboarding.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ht.employeeonboarding.entity.EmployeeQualification;

@Repository
public interface EmployeeQualificationRepository extends JpaRepository<EmployeeQualification, Long> {
}
