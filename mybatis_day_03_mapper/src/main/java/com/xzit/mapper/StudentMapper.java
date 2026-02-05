package com.xzit.mapper;

import com.xzit.model.Student;

import java.util.List;

public interface StudentMapper {
    void insert(Student student);
    void update(Student student);
    void delete(int id);
    List<Student> selectList();
    Student selectId(int id);
}
