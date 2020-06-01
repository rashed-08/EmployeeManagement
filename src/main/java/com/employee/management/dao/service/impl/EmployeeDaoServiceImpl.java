package com.employee.management.dao.service.impl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> getAllEmployee = new ArrayList<>();
        getAllEmployee = (List<Employee>) employeeRepository.findAll();
        return getAllEmployee;
    }

    @Override
    public Employee getEmployee(int id) {
        if (getAllEmployee().size() > id) {
            return null;
        } else {
            Employee employee = employeeRepository.getOne(id);
            return employee;
        }
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee retrieveEmployee = getEmployee(id);
        if (retrieveEmployee == null) {
            return null;
        } else {
            Employee updateEmployee = employeeRepository.save(employee);
            return updateEmployee;
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Employee retrieveEmployee = getEmployee(id);
        if (retrieveEmployee == null) {
            return ;
        } else {
            employeeRepository.delete(retrieveEmployee);
        }
    }

}
