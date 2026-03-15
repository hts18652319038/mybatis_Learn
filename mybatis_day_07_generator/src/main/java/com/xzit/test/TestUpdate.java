package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.model.StudentExample;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestUpdate {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        /*Student student = mapper.selectByPrimaryKey(19);
        student.setName("李逵");
        mapper.updateByPrimaryKey(student);*/
        Student student = new Student();
        student.setName("李白");
        StudentExample example = new StudentExample();
        example.createCriteria().andNameEqualTo("李太白").andGenderEqualTo("男");
        mapper.updateByExampleSelective(student,example);

        session.commit();
        session.close();
    }
}
