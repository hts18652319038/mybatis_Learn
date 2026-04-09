package com.xzit;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzit.dao.UserDao;
import com.xzit.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisDql02ApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // 按条件查询
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.lt("age", 23);
//        List<User> userList = userDao.selectList(wrapper);
//        System.out.println(userList);

/*        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.lt(User::getAge, 28);
//        queryWrapper.gt(User::getAge, 22);
//        queryWrapper.lt(User::getAge, 22).or().gt(User::getAge, 28);
        queryWrapper.select(User::getId,User::getName,User::getAge);
        List<User> list = userDao.selectList(queryWrapper);
        list.forEach(System.out::println);*/

//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.select("count(*) as count");
//        List<Map<String, Object>> maps = userDao.selectMaps(queryWrapper);
//        for (Map<String, Object> map : maps) {
//            System.out.println(map);
//        }
/*        // 条件查询
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        // 等同于=
        lqw.eq(User::getName,"Tom666").eq(User::getPassword,"123456");

        List<User> list = userDao.selectList(lqw);
        System.out.println(list);*/

        // 模糊匹配
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(User::getName,"张");
        List<User> list = userDao.selectList(lqw);
        list.forEach(System.out::println);
    }

}
