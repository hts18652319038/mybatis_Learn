package com.xzit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.dao.UserDao;
import com.xzit.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusQuickstart01ApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        List<User> userList = userDao.selectList(null);
        System.out.println(userList);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setId(6);
        user.setName("孟安慷");
        user.setPassword("123456");
        user.setAge(23);
        user.setTel("12346782345");
        userDao.insert(user);
    }

    @Test
    void testDelete() {
        userDao.deleteById(6);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(6);
        user.setName("Tom666");
        userDao.updateById(user);
    }

    @Test
    void testGetByPage() {
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getTotal());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }

}
