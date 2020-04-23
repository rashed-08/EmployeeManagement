package com.employee.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok(controllerService.getAllEmployee());
    }
    
    @PostMapping
    public void createEmployee(@Valid @RequestBody Employee employee) {
        controllerService.createEmployee(employee);
        //ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(controllerService.findEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id) {
        return ResponseEntity.ok(controllerService.updateEmployee(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.ok(controllerService.deleteEmployee(id));
    }
}
