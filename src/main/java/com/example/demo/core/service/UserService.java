package com.example.demo.core.service;

import com.example.demo.core.entity.User;
import com.example.demo.core.entity.UserCriteria;

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
