package com.employee.management;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    @DisplayName("First Test")
    public void shouldSavedEmployee() {
        Employee employee = new Employee("first","last","user","pass","email","add");
        employeeService.createEmployee(employee);
        verify(employeeRepository, times(1)).createEmployee(employee);;
    }
    
    @Test
    @DisplayName("Second Test")
    public void trySavedEmployeeMultipleTimes() {
        Employee employee = new Employee("first","last","user","pass","email","add");
        employeeService.createEmployee(employee);
        verify(employeeRepository, times(2)).createEmployee(employee);;
    }

}
