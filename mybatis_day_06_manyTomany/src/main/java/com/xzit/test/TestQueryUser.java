package com.xzit.test;

import com.xzit.mapper.UsersMapper;
import com.xzit.model.Role;
import com.xzit.model.Users;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestQueryUser {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        List<Users> users = mapper.selectList();
        for (Users user : users) {
            System.out.println(user.getUname()+"\t"+user.getPwd());
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                System.out.println("\t\t" + role.getRname());
            }
        }
        session.close();
    }
}
