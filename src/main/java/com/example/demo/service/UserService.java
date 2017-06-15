package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserCriteria;

import java.util.List;

/**
 * @author zhangmz
 * @create 2017/6/15
 */
public interface UserService {
    /**
     * 新增用户
     * @param user 用户
     */
    void add(User user);

    /**
     * 根据用户条件查询 用户集合
     * @param criteria UserCriteria
     * @return List<User>
     */
    List<User> findUserList(UserCriteria criteria);

}
