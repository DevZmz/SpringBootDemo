package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserCriteria;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户 控制器
 * @author zhangmz
 * @create 2017/6/15
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * TODO: 后面加入参数校验
     * 添加用户
     * @param user 用户
     */
    @RequestMapping("/add")
    public String add(User user){
        if(user.getId()!=null) {
            this.userService.add(user);
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @RequestMapping("/users")
    public List<User> getUserList(String name){
        UserCriteria criteria = null;
        if(!StringUtils.isEmpty(name)){
            criteria = new UserCriteria();
            criteria.createCriteria().andUsernameLike(name);
        }
        return this.userService.findUserList(criteria);
    }


}
