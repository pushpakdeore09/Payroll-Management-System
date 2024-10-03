package com.payrollBackend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.payrollBackend.service.DepartmentDeserialize;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    @JsonDeserialize(using = DepartmentDeserialize.class)
    private Department department;

    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String lastName, String gender, Date joiningDate, Date dob, String email, String address, Double baseSalary, String employeeType, String designation, Department department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.joiningDate = joiningDate;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.baseSalary = baseSalary;
        this.employeeType = employeeType;
        this.designation = designation;
        this.department = department;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
