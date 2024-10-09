package com.payrollBackend.repository;

import com.payrollBackend.model.PayrollMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayrollMonthRepository extends JpaRepository<PayrollMonth, Integer> {

}
