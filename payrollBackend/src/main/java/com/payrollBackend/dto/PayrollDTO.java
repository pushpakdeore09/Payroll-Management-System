package com.payrollBackend.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public class PayrollDTO {
    private String payrollName;
    private Integer employeeId;
    private String monthName;
    private Integer year;

    public PayrollDTO(String payrollName, Integer employeeId, String monthName, Integer year) {
        this.employeeId = employeeId;
        this.monthName = monthName;
        this.payrollName = payrollName;
        this.year = year;
    }

    public PayrollDTO() {

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public String getPayrollName() {
        return payrollName;
    }

    public void setPayrollName(String payrollName) {
        this.payrollName = payrollName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
