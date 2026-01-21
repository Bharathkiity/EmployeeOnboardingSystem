package com.ht.employeeonboarding.service;

import com.ht.employeeonboarding.entity.Employee;
import com.ht.employeeonboarding.entity.EmployeeAddress;
import com.ht.employeeonboarding.repo.EmployeeAddressRepository;
import com.ht.employeeonboarding.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeAddressRepository employeeAddressRepository;

	/**
	 * Save a new Employee
	 */
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * Retrieve all Employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Retrieve Employee by ID
	 */
	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	/**
	 * Update Employee details
	 */
	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		return employeeRepository.findById(id).map(existingEmployee -> {
			existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
			existingEmployee.setEmployeeMobile(updatedEmployee.getEmployeeMobile());
			existingEmployee.setEmployeeDesignation(updatedEmployee.getEmployeeDesignation());
			existingEmployee.setDepartment(updatedEmployee.getDepartment());
			existingEmployee.setEmployeeDesignation(updatedEmployee.getEmployeeDesignation());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			return employeeRepository.save(existingEmployee);
		}).orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
	}

	/**
	 * Delete an Employee by ID
	 */
	@Override
	public void deleteEmployee(Long id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		} else {
			throw new RuntimeException("Employee with ID " + id + " not found");
		}
	}
}
