package com.xzit.mapper;

import com.xzit.model.Stu;
import com.xzit.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectCondition(Student student);
    List<Student> selectConditionChoose(Student student);
    List<Student> selectConditionTrim(Student student);
    void update(Student student);
    void deleteCheck(int[] ids);
    void deleteCheckList(List<Integer> ids);
    void delete(Student student);
    void insert(List<Stu> list);
    List<Stu> selectByName(Stu stu);
    long count(Student student);
}
