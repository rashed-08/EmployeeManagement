package com.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/v1/employees")
@CrossOrigin("*")
public class MainController {
    
    @Autowired
    private ControllerServiceImpl controllerService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> getAllEmployee = controllerService.getAllEmployee();
        if (getAllEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(getAllEmployee);
        }
    }
    
    @PostMapping
    public ResponseEntity<HttpStatus> createEmployee(@RequestBody Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.noContent().build();
        }
        controllerService.createEmployee(employee);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        Employee employee = controllerService.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(employee);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
        System.out.println(employee.toString());
        Employee getEmployee = controllerService.updateEmployee(id, employee);
        if (getEmployee == null) {
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
        controllerService.deleteEmployee(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
