package com.aop.serviceImpl;

import com.aop.model.Employee;
import com.aop.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();
    public EmployeeServiceImpl(){
        employees.add(new Employee(1,"Prabhas","prabhas@gmail.com"));
        employees.add(new Employee(2,"Charan","charan@gmail.com"));
    }
    @Override
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId() == id).findFirst();
        return employee.stream().filter(emp -> emp.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Employee Not Found"));
    }
}
