package com.xzit.dao.impl;

import com.xzit.dao.StudentDao;
import com.xzit.model.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int save(Student student) {
        SqlSession session = getSession();
        int i = session.insert("insertObject", student);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public int delete(int id) {
        SqlSession session = getSession();
        int i = session.delete("delete", id);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public int update(Student student) {
        SqlSession session = getSession();
        int i = session.update("update", student);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public List<Student> selectList() {
        SqlSession session = getSession();
        List<Student> list = session.selectList("selectList");
        session.close();
        return list;
    }

    @Override
    public Student selectId(int id) {
        SqlSession session = getSession();
        Student student = session.selectOne("selectById", id);
        session.close();
        return student;
    }
}
