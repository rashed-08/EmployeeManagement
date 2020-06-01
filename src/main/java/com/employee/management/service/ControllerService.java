package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface ControllerService {
    
    List<Employee> getAllEmployee();
    void createEmployee(Employee employee);
    Employee findEmployeeById(int id);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
