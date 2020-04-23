package com.employee.management.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.management.dao.service.EmployeeDaoService;
import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

@Repository
public class EmployeeDaoServiceImpl implements EmployeeDaoService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

}
