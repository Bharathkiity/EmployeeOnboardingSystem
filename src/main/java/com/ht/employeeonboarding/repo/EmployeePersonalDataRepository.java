package com.ht.employeeonboarding.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ht.employeeonboarding.entity.EmployeePersonalData;

@Repository
public interface EmployeePersonalDataRepository extends JpaRepository<EmployeePersonalData, Long> {
}
