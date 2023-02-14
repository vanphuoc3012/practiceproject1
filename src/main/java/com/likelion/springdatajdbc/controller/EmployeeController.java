package com.likelion.springdatajdbc.controller;

import com.likelion.springdatajdbc.model.EmployeeEntity;
import com.likelion.springdatajdbc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/mybatis")
    public ResponseEntity<?> getAll() {
        List<EmployeeEntity> all = employeeRepository.findAll();

        return ResponseEntity.ok(all);

    }
}
