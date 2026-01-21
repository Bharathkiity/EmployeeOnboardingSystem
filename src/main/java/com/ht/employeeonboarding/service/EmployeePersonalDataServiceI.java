package com.ht.employeeonboarding.service;

import java.util.List;
import java.util.Optional;

import com.ht.employeeonboarding.entity.EmployeePersonalData;

public interface EmployeePersonalDataServiceI {
	EmployeePersonalData addPersonalDataToEmployee(Long employeeId, EmployeePersonalData personalData);

	List<EmployeePersonalData> getAllPersonalData();

	Optional<EmployeePersonalData> getPersonalDataById(Long id);

	void deletePersonalData(Long id);

	
    EmployeePersonalData updatePersonalData(Long id, EmployeePersonalData updatedPersonalData); // ✅ Added Update Method

}
