package com.xzit.test;

import com.xzit.mapper.UsersMapper;
import com.xzit.model.Role;
import com.xzit.model.Users;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class TestLoginUser {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Users user = new Users();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录系统：");
        user.setUname(scanner.next());
        user.setPwd(scanner.next());
        Users users = mapper.login(user);
        if (users==null){
            System.out.println("登录失败");
        }else {
            System.out.println("欢迎用户"+user.getUname());
            System.out.println("您的角色是：");
            List<Role> list = users.getRoles();
            for (Role role : list) {
                System.out.println(role.getRname());
            }
        }
        session.close();
    }
}
