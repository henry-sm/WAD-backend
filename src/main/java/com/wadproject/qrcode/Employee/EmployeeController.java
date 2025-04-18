package com.wadproject.qrcode.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wadproject.qrcode.Organisation.OrganisationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OrganisationRepository organisationRepository;

    // Create a new Employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        if (!organisationRepository.existsById(employee.getOrganisationId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       
        if(employeeRepository.existsByEmail(employee.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Delete Employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Mark Atendance of an Employee
    @PostMapping("/{id}/attend")
    public ResponseEntity<Map<String,String>> markEmployeeAttendance(@PathVariable String id) {
        System.out.println(id);
        Optional<Employee> _employee = employeeRepository.findById(id);
        Map<String,String> map = new HashMap<>();

        if(_employee.isPresent()){
            Employee emp = _employee.get();

            if (LocalDate.now().equals(emp.getLastMarkedAt())) {
                map.put("message","Employee Already Marked");
                return new ResponseEntity<>(map, HttpStatus.CONFLICT);
            }else{
                emp.addLogs(LocalDateTime.now().toString());
                emp.setLastMarkedAt(LocalDate.now());
            }

            employeeRepository.save(emp);
        }else{
            map.put("message","Employee not Found");
            return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        
        map.put("message","Attendance Updated");
        //Implement the response
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
