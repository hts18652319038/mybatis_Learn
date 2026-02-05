package com.xzit.mapper;

import com.xzit.model.Employees;

import java.util.List;

public interface EmployeesMapper {
    void insert(Employees employees);
    void update(Employees employees);
    void delete(int id);
    List<Employees> selectList();
    Employees selectId(int id);
}
