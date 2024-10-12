package com.payrollBackend.service;

import com.payrollBackend.model.Department;
import com.payrollBackend.repository.DepartmentRepository;
import com.payrollBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<String> createDepartment(Department department){
        System.out.println(department.getDeptName());
        Optional<Department> isDeptExist = Optional.ofNullable(departmentRepository.findByDeptName(department.getDeptName()));
        if(isDeptExist.isPresent()){
            return new ResponseEntity<>("Department already exists", HttpStatus.CONFLICT);
        }

        Department newDepartment = new Department();

        newDepartment.setDeptName(department.getDeptName());
        departmentRepository.save(newDepartment);

        return new ResponseEntity<>("Department added", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteDepartment(Integer deptId) throws Exception{

        Department department = findDepartmentById(deptId);
        departmentRepository.delete(department);
        return new ResponseEntity<>("Department removed", HttpStatus.OK);
    }

    public Department findDepartmentById(Integer deptId) throws Exception{
        Optional<Department> department = departmentRepository.findById(deptId);
        if (department.isEmpty()){
            throw new Exception("Department not found");
        }
        return department.get();
    }
    public ResponseEntity<?> findDepartmentByName(String deptName) {
        Department department = departmentRepository.findByDeptName(deptName);
        if (department != null && department.getDeptName().equalsIgnoreCase(deptName)) {
                return new ResponseEntity<>(department, HttpStatus.OK);
        }
        return new ResponseEntity<>("Department not found", HttpStatus.BAD_REQUEST);
    }

    public List<Department> findAllDepartment(){
        List<Department> departments = departmentRepository.findAll();

        for (Department department : departments) {
            Integer employeeCount = employeeRepository.countByDepartment_DeptId(department.getDeptId());
            department.setEmployeeCount(employeeCount);
        }

        return departments;
    }
}
