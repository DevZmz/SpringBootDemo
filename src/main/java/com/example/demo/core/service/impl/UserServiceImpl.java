package com.example.demo.core.service.impl;

import com.example.demo.core.entity.User;
import com.example.demo.core.entity.UserCriteria;
import com.example.demo.core.mapper.UserMapper;
import com.example.demo.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务类
 * @author zhangmz
 * @create 2017/6/15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        if (this.userMapper.insertSelective(user)==0) {
            throw new RuntimeException("新增用户失败");
        }
    }


    @Override
    public List<User> findUserList(UserCriteria criteria) {
        return this.userMapper.selectByExample(criteria);
    }
}
