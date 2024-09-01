package com.project.Video_Streming_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Video_Streming_app.model.Employee;
import com.project.Video_Streming_app.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo employeeRepo;
	@Override
	public void createEmployee(Employee employee) {

		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) {
		return employeeRepo.findById(id);
	}

}
