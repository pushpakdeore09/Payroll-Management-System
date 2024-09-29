package com.payrollBackend.service;

import com.payrollBackend.model.Department;
import com.payrollBackend.model.Employee;
import com.payrollBackend.repository.DepartmentRepository;
import com.payrollBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<String> addEmployee(Employee employee) {

        Department department = departmentRepository.findById(employee.getDepartment().getDeptId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
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
        newEmployee.setDepartment(department);

        employeeRepository.save(newEmployee);
        return new ResponseEntity<>("Employee added Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> removeEmployee(Integer employeeId) throws Exception {

        Employee employee = findByEmployeeId(employeeId);
        employeeRepository.delete(employee);

        return new ResponseEntity<>("Employee removed", HttpStatus.OK);
    }

    public Employee findByEmployeeId(Integer employeeId) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            throw new Exception("Employee not found");
        }
        return employee.get();
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
