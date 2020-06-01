package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface EmployeeServices {
    
    void createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployee(int id);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
