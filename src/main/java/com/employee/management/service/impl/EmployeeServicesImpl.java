package com.employee.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.dao.service.impl.EmployeeDaoServiceImpl;
import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeDaoServiceImpl employeeDaoService;

    @Override
    public void createEmployee(Employee employee) {
        employeeDaoService.createEmployee(employee);
    } 

}
