package com.xzit.mapper;

import com.xzit.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectCondition(Employee employee);
    Double countSalary(Employee employee);
    void update(Employee employee);
    void delteCheck(int[] ids);
}
