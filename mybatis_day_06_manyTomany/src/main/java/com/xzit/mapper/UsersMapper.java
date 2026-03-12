package com.xzit.mapper;

import com.xzit.model.Users;

import java.util.List;

public interface UsersMapper {
    List<Users> selectList();
    Users login(Users user);
    void delete(int rid);
    void deleteUser(int uid);
}
