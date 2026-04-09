package com.xzit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzit.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
