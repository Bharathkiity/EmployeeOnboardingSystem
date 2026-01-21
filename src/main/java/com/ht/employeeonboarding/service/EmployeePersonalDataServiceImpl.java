package com.ht.employeeonboarding.service;


import com.ht.employeeonboarding.entity.Employee;
import com.ht.employeeonboarding.entity.EmployeePersonalData;
import com.ht.employeeonboarding.repo.EmployeePersonalDataRepository;
import com.ht.employeeonboarding.repo.EmployeeRepository;
import com.ht.employeeonboarding.service.EmployeePersonalDataServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePersonalDataServiceImpl implements EmployeePersonalDataServiceI {
	
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeePersonalDataRepository employeePersonalDataRepository;

    @Override
    public EmployeePersonalData addPersonalDataToEmployee(Long employeeId, EmployeePersonalData personalData) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        personalData.setEmployee(employee); // Associate personal data with employee
        return employeePersonalDataRepository.save(personalData);
    }
    @Override
    public List<EmployeePersonalData> getAllPersonalData() {
        return employeePersonalDataRepository.findAll();
    }

    @Override
    public Optional<EmployeePersonalData> getPersonalDataById(Long id) {
        return employeePersonalDataRepository.findById(id);
    }
    @Override
    public EmployeePersonalData updatePersonalData(Long id, EmployeePersonalData updatedPersonalData) {
        EmployeePersonalData existingPersonalData = employeePersonalDataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal Data not found with ID: " + id));

        // ✅ Update fields if provided
        if (updatedPersonalData.getResume() != null) {
            existingPersonalData.setResume(updatedPersonalData.getResume());
        }
        if (updatedPersonalData.getAadharCard() != null) {
            existingPersonalData.setAadharCard(updatedPersonalData.getAadharCard());
        }
        if (updatedPersonalData.getPanCard() != null) {
            existingPersonalData.setPanCard(updatedPersonalData.getPanCard());
        }
        if (updatedPersonalData.getPassportPhoto() != null) {
            existingPersonalData.setPassportPhoto(updatedPersonalData.getPassportPhoto());
        }

        return employeePersonalDataRepository.save(existingPersonalData);
    }

    @Override
    public void deletePersonalData(Long id) {
        employeePersonalDataRepository.deleteById(id);
    }
}
