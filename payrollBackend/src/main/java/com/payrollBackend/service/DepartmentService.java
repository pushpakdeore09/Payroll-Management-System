package com.payrollBackend.service;

import com.payrollBackend.model.Department;
import com.payrollBackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<String> createDepartment(Department department){

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

    public List<Department> findAllDepartment(){
        return departmentRepository.findAll();
    }
}
