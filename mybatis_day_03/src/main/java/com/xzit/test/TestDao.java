package com.xzit.test;

import com.xzit.dao.StudentDao;
import com.xzit.dao.impl.StudentDaoImpl;
import com.xzit.model.Student;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        // 显示全部数据
        // list(dao);
        // 保存
        // save(dao);
        // 更新
        // update(dao);
        // 删除
        delete(dao);
    }

    public static void list(StudentDao dao){
        List<Student> list = dao.selectList();
        list.forEach(System.out::println);
    }

    public static void save(StudentDao dao){
        Student student = new Student(7, "杜甫",20,"男");
        System.out.println(dao.save(student) > 0 ? "保存成功" : "保存失败");
    }

    public static void update(StudentDao dao){
        Student student = dao.selectId(2);
        student.setName("陆游").setAge(25).setGender("男");
        System.out.println((dao.update(student) > 0 ? "更新成功" : "更新失败"));
    }

    public static void delete(StudentDao dao){
        System.out.println((dao.delete(11) > 0 ? "删除成功" : "删除失败"));
    }
}
