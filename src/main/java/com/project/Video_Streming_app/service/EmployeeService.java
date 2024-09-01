package com.project.Video_Streming_app.service;

import java.util.List;
import java.util.Optional;

import com.project.Video_Streming_app.model.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Optional<Employee>getEmployee(Integer id);
}
