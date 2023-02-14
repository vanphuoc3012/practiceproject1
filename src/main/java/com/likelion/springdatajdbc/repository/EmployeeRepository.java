package com.likelion.springdatajdbc.repository;

import com.likelion.springdatajdbc.model.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeRepository {

    @Select("SELECT * FROM employees")
    List<EmployeeEntity> findAll();
}
