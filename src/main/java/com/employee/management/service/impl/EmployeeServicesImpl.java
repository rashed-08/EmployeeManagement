package com.employee.management.service.impl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> getAllEmployee = new ArrayList<>();
        getAllEmployee = employeeDaoService.getAllEmployee();
        if (getAllEmployee.isEmpty()) {
            return null;
        } else {
            return getAllEmployee;
        }
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = employeeDaoService.getEmployee(id);
        if (employee == null) {
            return null;
        } else {
            return employee;
        }
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee updateEmployee = employeeDaoService.updateEmployee(id, employee);
        if (updateEmployee == null) {
            return null;
        } else {
            return updateEmployee;
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDaoService.deleteEmployee(id);
    }

}
