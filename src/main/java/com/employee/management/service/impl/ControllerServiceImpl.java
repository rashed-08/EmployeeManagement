package com.employee.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.model.Employee;
import com.employee.management.service.ControllerService;

@Service
public class ControllerServiceImpl implements ControllerService {
    
    @Autowired
    private EmployeeServicesImpl employeeService; 

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee updateEmployee(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee deleteEmployee(int id) {
        // TODO Auto-generated method stub
        return null;
    }

}
