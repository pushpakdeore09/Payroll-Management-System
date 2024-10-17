package com.payrollBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.payrollBackend.service.DepartmentDeserialize;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "base_salary")
    private Double baseSalary;

    @Column(name = "employee_type")
    private String employeeType;

    @Column(name = "designation")
    private String designation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    @JsonDeserialize(using = DepartmentDeserialize.class)
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Allowances> allowances;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Deductions> deductions;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Tax> taxes;


    @Column(name = "net_salary")
    private Double netSalary;

    public Employee() {
    }

    public Employee(String address, List<Allowances> allowances, Double baseSalary, List<Deductions> deductions, Department department, String designation, Date dob, String email, Integer employeeId, String employeeType, String firstName, String gender, Date joiningDate, String lastName, List<Tax> taxes, Double netSalary) {
        this.address = address;
        this.allowances = allowances;
        this.baseSalary = baseSalary;
        this.deductions = deductions;
        this.department = department;
        this.designation = designation;
        this.dob = dob;
        this.email = email;
        this.employeeId = employeeId;
        this.employeeType = employeeType;
        this.firstName = firstName;
        this.gender = gender;
        this.joiningDate = joiningDate;
        this.lastName = lastName;
        this.taxes = taxes;
        this.netSalary = netSalary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Allowances> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<Allowances> allowances) {
        this.allowances = allowances;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Deductions> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deductions> deductions) {
        this.deductions = deductions;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }
}
