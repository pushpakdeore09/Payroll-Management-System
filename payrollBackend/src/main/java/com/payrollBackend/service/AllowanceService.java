package com.payrollBackend.service;

import com.payrollBackend.dto.AllowanceDTO;
import com.payrollBackend.model.Allowances;
import com.payrollBackend.model.Employee;
import com.payrollBackend.repository.AllowanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AllowanceService {

    @Autowired
    private AllowanceRepository allowanceRepository;

    @Autowired
    private EmployeeService employeeService;

    public ResponseEntity<?> addAllowance(AllowanceDTO allowanceDTO){

        Employee employee = employeeService.findByEmployeeId(allowanceDTO.getEmployeeId());
        if(employee == null) {
            return new ResponseEntity<>("Employee not found", HttpStatus.BAD_REQUEST);
        }
        Allowances oldAllowances = allowanceRepository.findByAllowanceName(allowanceDTO.getAllowanceName());
        if(oldAllowances != null && oldAllowances.getAllowanceName().equalsIgnoreCase(allowanceDTO.getAllowanceName()) && Objects.equals(allowanceDTO.getEmployeeId(), employee.getEmployeeId())){
            return new ResponseEntity<>("Allowance already exists", HttpStatus.BAD_REQUEST);
        }
        Double allowanceAmount = (allowanceDTO.getAllowancePercentage()/100) * employee.getBaseSalary();
        Allowances newAllowances = new Allowances();
        newAllowances.setAllowanceName(allowanceDTO.getAllowanceName());
        newAllowances.setAllowanceType(allowanceDTO.getAllowanceType());
        newAllowances.setAllowancePercentage(allowanceDTO.getAllowancePercentage());
        newAllowances.setAllowanceAmount(allowanceAmount);
        newAllowances.setEmployee(employee);
        allowanceRepository.save(newAllowances);
        return new ResponseEntity<>("Allowance added Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllowancesByEmployeeId(Integer employeeId){
        List<Allowances> allowances = allowanceRepository.findByEmployee_EmployeeId(employeeId);
        if(allowances.isEmpty()){
            return new ResponseEntity<>("Allowances not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(allowances, HttpStatus.OK);
    }
}
