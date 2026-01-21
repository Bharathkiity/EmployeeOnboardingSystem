package com.ht.employeeonboarding.controller;

import com.ht.employeeonboarding.entity.EmployeePersonalData;
import com.ht.employeeonboarding.service.EmployeePersonalDataServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees/{employeeId}/personal-data")
@CrossOrigin("http://localhost:4200") // angular url acess by angular or any
public class EmployeePersonalDataController {

    @Autowired
    private EmployeePersonalDataServiceI personalDataService;

    @PostMapping
    public EmployeePersonalData addPersonalDataToEmployee(
            @PathVariable Long employeeId,
            @RequestBody EmployeePersonalData personalData) {
        return personalDataService.addPersonalDataToEmployee(employeeId, personalData);
    }

    @GetMapping
    public List<EmployeePersonalData> getAllPersonalData() {
        return personalDataService.getAllPersonalData();
    }

    @GetMapping("/{id}")		
    public Optional<EmployeePersonalData> getPersonalDataById(@PathVariable Long id) {
        return personalDataService.getPersonalDataById(id);
    }
    
    
    @PutMapping("/{id}")
    public EmployeePersonalData updatePersonalData(
            @PathVariable Long id,
            @RequestBody EmployeePersonalData updatedPersonalData) {
        return personalDataService.updatePersonalData(id, updatedPersonalData);
    }
    @DeleteMapping("/{id}")
    public void deletePersonalData(@PathVariable Long id) {
        personalDataService.deletePersonalData(id);
    }
}
