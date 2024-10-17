package com.payrollBackend.service;

import com.payrollBackend.model.*;
import com.payrollBackend.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private DeductionRepository deductionRepository;

    @Autowired
    private AllowanceRepository allowanceRepository;
    @Transactional
    public ResponseEntity<Map<String, Object>> addEmployee(Employee employee) {
        Department department = departmentRepository.findByDeptName(employee.getDepartment().getDeptName());
        Optional<Employee> isEmpExist = Optional.ofNullable(employeeRepository.findByEmail(employee.getEmail()));
        if(isEmpExist.isPresent()){
            return new ResponseEntity<>(Map.of("message", "Employee already exists"), HttpStatus.CONFLICT);
        }
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
        newEmployee.setNetSalary(0.0);
        employeeRepository.save(newEmployee);
        if (department.getEmployeeCount() == null) {
            department.setEmployeeCount(1);
        } else {
            department.setEmployeeCount(department.getEmployeeCount() + 1);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee added successfully");
        response.put("employeeId", newEmployee.getEmployeeId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<String> removeEmployee(Integer employeeId) throws Exception {

        Employee employee = findByEmployeeId(employeeId);

        // Delete all related payrolls
        List<Payroll> payrolls = payrollRepository.findByEmployee(employee);
        if (payrolls != null && !payrolls.isEmpty()) {
            payrollRepository.deleteAll(payrolls);
        }

        // Delete all related allowances
        List<Allowances> allowances = allowanceRepository.findByEmployee(employee);
        if (allowances != null && !allowances.isEmpty()) {
            allowanceRepository.deleteAll(allowances);
        }

        // Delete all related deductions
        List<Deductions> deductions = deductionRepository.findByEmployee(employee);
        if (deductions != null && !deductions.isEmpty()) {
            deductionRepository.deleteAll(deductions);
        }

        // Delete the employee
        employeeRepository.delete(employee);

        // Update department's employee count
        Department department = employee.getDepartment();
        if (department != null) {
            // Fetch the department from the database to ensure it's attached to the persistence context
            Department existingDepartment = departmentRepository.findById(department.getDeptId())
                    .orElseThrow(() -> new Exception("Department not found"));

            // Decrement employee count
            existingDepartment.setEmployeeCount(existingDepartment.getEmployeeCount() - 1);

            // Save the updated department (without inserting a new one)
            departmentRepository.save(existingDepartment);
        }

        return new ResponseEntity<>("Employee removed Successfully", HttpStatus.OK);
    }


    public Employee findByEmployeeId(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.orElse(null);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<?> findEmployee(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> editEmployeeDetails(Employee employee) throws Exception {
        Integer employeeId = employee.getEmployeeId();
        Optional<Employee> optionalOldEmployee = Optional.ofNullable(findByEmployeeId(employeeId));

        if (optionalOldEmployee.isEmpty()) {
            return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
        }

        Employee existingEmployee = optionalOldEmployee.get();

        Field[] fields = Employee.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(employee);
                if (value != null) {
                    field.set(existingEmployee, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        employeeRepository.save(existingEmployee);

        return new ResponseEntity<>("Employee updated Successfully", HttpStatus.OK);
    }

}
