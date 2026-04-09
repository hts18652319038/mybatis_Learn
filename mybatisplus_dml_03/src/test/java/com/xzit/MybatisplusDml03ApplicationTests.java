package com.xzit;

import com.xzit.dao.UserDao;
import com.xzit.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisplusDml03ApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testSave() {
        User user = new User();
        user.setName("程序架构师");
        user.setPassword("20030106");
        user.setAge(18);
        user.setTel("18802106");
        userDao.insert(user);
    }

    @Test
    void testDelete() {
        /*userDao.deleteById(1);*/
/*        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(3L);
        list.add(7L);
        userDao.selectBatchIds(list);*/
        userDao.deleteById(4);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(7);
        user.setName("Yongwang Ju");
        user.setPassword("20021223");
        userDao.updateById(user);
    }

}
