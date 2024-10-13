package com.payrollBackend.dto;

public class AllowanceDTO {
    private String allowanceName;
    private Integer employeeId;
    private String allowanceType;
    private Double allowancePercentage;

    public AllowanceDTO(String allowanceName, Double allowancePercentage, String allowanceType, Integer employeeId) {
        this.allowanceName = allowanceName;
        this.allowancePercentage = allowancePercentage;
        this.allowanceType = allowanceType;
        this.employeeId = employeeId;
    }

    public AllowanceDTO() {
    }

    public String getAllowanceName() {
        return allowanceName;
    }

    public void setAllowanceName(String allowanceName) {
        this.allowanceName = allowanceName;
    }

    public Double getAllowancePercentage() {
        return allowancePercentage;
    }

    public void setAllowancePercentage(Double allowancePercentage) {
        this.allowancePercentage = allowancePercentage;
    }

    public String getAllowanceType() {
        return allowanceType;
    }

    public void setAllowanceType(String allowanceType) {
        this.allowanceType = allowanceType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
