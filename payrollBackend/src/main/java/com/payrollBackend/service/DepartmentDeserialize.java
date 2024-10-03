package com.payrollBackend.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.payrollBackend.model.Department;
import com.payrollBackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Optional;

public class DepartmentDeserialize extends JsonDeserializer<Department> {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        int departmentId = p.getIntValue(); // Read the ID from JSON
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentId));
    }
}
