package com.example.demo.core.controller;

import com.example.demo.core.entity.User;
import com.example.demo.core.entity.UserCriteria;
import com.example.demo.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户 控制器
 * @author zhangmz
 * @create 2017/6/15
 */
@Api("用户API")
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
    @ApiOperation(notes="添加用户",value="添加一个用户",httpMethod="POST")
    @ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
    @RequestMapping("/add")
    public String add(User user){
        if(user.getId()!=null) {
            this.userService.add(user);
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @ApiOperation(notes = "查询用户列表",value = "用户列表",httpMethod = "GET")
    @ApiImplicitParam(name = "name",value = "模糊查询用户姓名",required = true,dataType = "String")
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
