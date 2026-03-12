package com.xzit.mapper;

import com.xzit.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    List<Users> selectList();
    Users login(Users user);
    void delete(int rid);
    void deleteUser(int uid);
    int updateLastTime(@Param("uid") Integer uid, @Param("lasttime") java.util.Date lasttime);
}
