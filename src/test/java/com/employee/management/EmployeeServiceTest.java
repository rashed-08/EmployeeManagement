package com.employee.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employee.management.dao.service.impl.EmployeeDaoServiceImpl;
import com.employee.management.model.Employee;
import com.employee.management.service.impl.EmployeeServicesImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeDaoServiceImpl employeeRepository;

    @InjectMocks
    private EmployeeServicesImpl employeeService;

    @Test
    @DisplayName("Save Employee")
    public void shouldSavedEmployee() {
        Employee employee = new Employee(1, "first", "last", "user", "pass", "email","email1", "add");
        employeeService.createEmployee(employee);
        verify(employeeRepository, times(1)).createEmployee(employee);
        ;
    }

    @Test
    @DisplayName("Gell All Employee")
    public void getAllEmployeeTest() {
        List<Employee> allEmployee = Arrays.asList(new Employee(1, "one", "two", "user1", "pass", "emai","email1", "addr"),
                new Employee(2, "three", "four", "user2", "pass", "email","email1", "add"));
        given(employeeRepository.getAllEmployee()).willReturn(allEmployee);
        List<Employee> employeeList = employeeService.getAllEmployee();
        assertEquals(2, employeeList.size());
        verify(employeeRepository, times(1)).getAllEmployee();
    }
    
    @Test
    @DisplayName("Empty List")
    public void validateEmptyList() {
        List<Employee> emptyEmployeeList = Arrays.asList(new Employee());
        given(employeeRepository.getAllEmployee()).willReturn(emptyEmployeeList);
        List<Employee> emptyList = employeeService.getAllEmployee();
        assertFalse(emptyList.isEmpty());
    }

    @Test
    @DisplayName("Get Employee")
    public void getEmployee() {
        Employee employee = new Employee(1, "first", "last", "user", "pass", "email","email1", "add");
        given(employeeRepository.getEmployee(1)).willReturn(employee);
        Employee getEmployee = employeeService.getEmployee(1);
        assertEquals("first", getEmployee.getFirstName());
        assertEquals("add", getEmployee.getAddress());
        verify(employeeRepository, times(1)).getEmployee(employee.getId());
    }
    
    @Test
    @DisplayName("Employee Not Found")
    public void employeeNotFound() {
        Employee employee = new Employee();
        given(employeeRepository.getEmployee(5)).willReturn(employee);
        Employee retrieveEmployee = employeeService.getEmployee(5);
        assertNull(retrieveEmployee.getFirstName());
    }
    
}
