package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestMapper {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        // 自动生成当前接口的代理实现类
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        // 执行保存
        //mapper.insert(new Student(0,"李贺",22,"男"));
        // mapper.update(new Student(12,"李贺",25,"男"));
        // 执行查询1条数据
        // System.out.println(mapper.selectId(8));
        // 执行删除
        // mapper.delete(12);
        // session.commit();
        List<Student> list = mapper.selectList();
        list.forEach(System.out::println);
        session.close();
    }
}
