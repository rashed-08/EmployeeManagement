package com.employee.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.impl.ControllerServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class MainController {
    
    @Autowired
    private ControllerServiceImpl controllerService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> getAllEmployee = controllerService.getAllEmployee();
        if (getAllEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(getAllEmployee);
        }
    }
    
    @PostMapping
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
        controllerService.createEmployee(employee);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        Employee employee = controllerService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id) {
        Employee employee = controllerService.updateEmployee(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        controllerService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
