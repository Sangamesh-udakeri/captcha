package com.project.Video_Streming_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Video_Streming_app.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
