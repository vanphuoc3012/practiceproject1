package com.likelion.springdatajdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    private Long employee_id;

    private String first_name;

    private String last_name;

    private String email;

    private String phone_number;

    private Date hire_date;

    private String job_id;

    private Long salary;

    private Double commission_pct;

    private Long manager_id;

    private Long department_id;

}
