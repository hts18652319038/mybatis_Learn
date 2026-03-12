package com.xzit.test;

import com.xzit.mapper.UsersMapper;
import com.xzit.model.Permision;
import com.xzit.model.Role;
import com.xzit.model.Users;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
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
            /*System.out.println("欢迎用户"+user.getUname());
            System.out.println("您的角色是：");
            List<Role> list = users.getRoles();
            for (Role role : list) {
                System.out.println(role.getRname());
            }*/

            // 1. 更新最后访问时间（当前系统时间）
            int updateCount = mapper.updateLastTime(users.getUid(), new Date());
            if (updateCount > 0) {
                session.commit(); // 提交事务，更新生效
                System.out.println("====================登录成功====================");
                System.out.println("欢迎用户：" + users.getUname());
            }

            // 2. 展示角色和权限
            List<Role> roleList = users.getRoles();
            if (roleList != null && !roleList.isEmpty()) {
                for (Role role : roleList) {
                    System.out.println("\n您是：" + role.getRname());
                    System.out.println("可操作菜单：");
                    // 展示权限链接
                    List<Permision> permList = role.getPermissions();
                    if (permList != null && !permList.isEmpty()) {
                        for (Permision perm : permList) {
                            System.out.println("<a href='" + perm.getUrl() + "'>" + perm.getPname() + "</a>");
                        }
                    } else {
                        System.out.println("暂无操作权限");
                    }
                }
            } else {
                System.out.println("暂无分配角色");
            }
        }
        session.close();
    }
}
