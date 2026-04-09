package com.xzit.service.impl;

import com.xzit.domain.User;
import com.xzit.dao.UserDao;
import com.xzit.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tongshun Huang
 * @since 2026-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
