package com.wadproject.qrcode.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new Employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return null;
    }

    // Delete Employee by ID
    @DeleteMapping("/{id}")
    public ResponseBody deleteEmployeeById(@PathVariable String id) {
        return null;
    }

    //Mark Atendance of an Employee
    @PostMapping("/{id}/attend")
    public ResponseBody markEmployeeAttendance(@PathVariable String id) {
        Optional<Employee> _employee = employeeRepository.findById(id);
        if(_employee.isPresent()){
            Employee emp = _employee.get();
            emp.markAttendance();
        }
        //Implement the response
        return null ;
    }
}
