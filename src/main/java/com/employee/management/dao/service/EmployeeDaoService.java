package com.employee.management.dao.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface EmployeeDaoService {
    
    void createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployee(int id);
    Employee updateEmployee(int id);
    void deleteEmployee(int id);
}
