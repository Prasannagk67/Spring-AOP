package com.aop.controller;

import com.aop.model.Employee;
import com.aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return ResponseEntity.ok(employee1);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
