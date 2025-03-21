package com.aop.service;

import com.aop.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
}
