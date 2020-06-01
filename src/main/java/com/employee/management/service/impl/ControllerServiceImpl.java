package com.employee.management.service.impl;

import java.util.ArrayList;
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
        List<Employee> getAllEmployee = new ArrayList<>();
        getAllEmployee = employeeService.getAllEmployee();
        if (getAllEmployee == null) {
            return null;
        } else {
            return getAllEmployee;
        }
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee getEmployee = employeeService.getEmployee(id);
        if (getEmployee == null) {
            return null;
        } else {
            return getEmployee;
        }
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(id, employee);
        if (updateEmployee == null) {
            return null;
        } else {
            return updateEmployee;
        }
    }

    @Override
    public void deleteEmployee(int id) {
       employeeService.deleteEmployee(id);
    }

}
