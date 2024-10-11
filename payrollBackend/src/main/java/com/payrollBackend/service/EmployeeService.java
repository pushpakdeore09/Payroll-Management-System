package com.payrollBackend.service;

import com.payrollBackend.model.Department;
import com.payrollBackend.model.Employee;
import com.payrollBackend.repository.DepartmentRepository;
import com.payrollBackend.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public ResponseEntity<String> addEmployee(Employee employee) {

        Department department = departmentRepository.findByDeptName(employee.getDepartment().getDeptName());

        Optional<Employee> isEmpExist = Optional.ofNullable(employeeRepository.findByEmail(employee.getEmail()));
        if(isEmpExist.isPresent()){
            return new ResponseEntity<>("Employee already Exist", HttpStatus.CONFLICT);
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

        employeeRepository.save(newEmployee);

        if (department.getEmployeeCount() == null) {
            department.setEmployeeCount(1);
        } else {
            department.setEmployeeCount(department.getEmployeeCount() + 1);
        }


        return new ResponseEntity<>("Employee added Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> removeEmployee(Integer employeeId) throws Exception {

        Employee employee = findByEmployeeId(employeeId);
        employeeRepository.delete(employee);

        return new ResponseEntity<>("Employee removed", HttpStatus.OK);
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
