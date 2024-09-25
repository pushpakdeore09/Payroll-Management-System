package com.payrollBackend.service;

import com.payrollBackend.model.Employee;
import com.payrollBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<String> addEmployee(Employee employee) {

        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setGender(employee.getGender());
        newEmployee.setJoiningDate(employee.getJoiningDate());
        newEmployee.setDob(employee.getDob());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setAddress(employee.getAddress());
        newEmployee.setBaseSalary(employee.getBaseSalary());
        newEmployee.setEmployeeType(employee.getEmployeeType());
        newEmployee.setDesignation(employee.getDesignation());
        newEmployee.setDepartment(employee.getDepartment());

        employeeRepository.save(newEmployee);


        return new ResponseEntity<>("Employee added Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> removeEmployee(Integer employeeId) {

        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);

        if(existingEmployee.isEmpty()){
            return new ResponseEntity<>("Employee does not exists", HttpStatus.BAD_REQUEST);
        }

    }
}
