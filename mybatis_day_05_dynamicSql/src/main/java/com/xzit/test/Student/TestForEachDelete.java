package com.xzit.test.Student;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.List;

public class TestForEachDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        /*int[] ids = new int[]{10,11};
        mapper.deleteCheck(ids);*/

        /*List<Integer> ids = Arrays.asList(2,4);
        mapper.deleteCheckList(ids);*/

        List<Integer> ids = Arrays.asList(2,4);
        Student student = new Student();
        student.setIds(ids);
        mapper.delete(student);

        session.commit();
        session.close();
    }
}
