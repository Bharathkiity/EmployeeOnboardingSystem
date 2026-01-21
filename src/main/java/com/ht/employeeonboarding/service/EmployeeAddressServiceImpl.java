package com.ht.employeeonboarding.service;

import com.ht.employeeonboarding.entity.AddressType;
import com.ht.employeeonboarding.entity.Employee;
import com.ht.employeeonboarding.entity.EmployeeAddress;
import com.ht.employeeonboarding.repo.EmployeeAddressRepository;
import com.ht.employeeonboarding.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressServiceI {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeAddressRepository employeeAddressRepository;

    @Override
    public EmployeeAddress saveAddressByEmployeeId(Long employeeId, EmployeeAddress address) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + employeeId + " not found"));
        
        address.setEmployee(employee);  // Set the employee reference
        return employeeAddressRepository.save(address);
    }

    @Override
    public List<EmployeeAddress> getAllAddresses() {
        return employeeAddressRepository.findAll();
    }

    @Override
    public Optional<EmployeeAddress> getAddressById(Long id) {
        return employeeAddressRepository.findById(id);
    }

    @Override
    public EmployeeAddress updatePermanentAddress(Long employeeId, Long addressId, EmployeeAddress updatedAddress) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + employeeId + " not found"));
        
        EmployeeAddress address = employeeAddressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address with ID " + addressId + " not found"));

        // Update fields
        address.setHouseNumber(updatedAddress.getHouseNumber());
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setState(updatedAddress.getState());
        address.setCountry(updatedAddress.getCountry());
        address.setPincode(updatedAddress.getPincode());
        address.setAddressType(AddressType.PERMANENT);  // Set type to PERMANENT

        return employeeAddressRepository.save(address);
    }

    @Override
    public EmployeeAddress updateTemporaryAddress(Long employeeId, Long addressId, EmployeeAddress updatedAddress) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + employeeId + " not found"));
        
        EmployeeAddress address = employeeAddressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address with ID " + addressId + " not found"));

        // Update fields
        address.setHouseNumber(updatedAddress.getHouseNumber());
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setState(updatedAddress.getState());
        address.setCountry(updatedAddress.getCountry());
        address.setPincode(updatedAddress.getPincode());
        address.setAddressType(AddressType.TEMPORARY);  // Set type to TEMPORARY

        return employeeAddressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        employeeAddressRepository.deleteById(id);
    }
}
