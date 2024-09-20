package com.payrollBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payrollmonth")
public class PayrollMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollMonthId;

    @Column(name = "month")
    private String monthName;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;
}

