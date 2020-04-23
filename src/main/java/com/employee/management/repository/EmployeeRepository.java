package com.employee.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.management.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, String>{

    Employee findByEmail(String email);
}
