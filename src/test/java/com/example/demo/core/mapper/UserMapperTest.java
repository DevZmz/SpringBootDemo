package com.example.demo.core.mapper;

import com.example.demo.core.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangmz
 * @create 2017/6/15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@EnableTransactionManagement
public class UserMapperTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void countByExample() throws Exception {
        this.logger.info("=============>> {} ",this.userMapper.countByExample(null));
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        User user = new User();
        user.setId(2);
        user.setUsername("22");
        user.setPsw("1111");
        this.userMapper.insert(user);
    }

    @Test
    public void insertSelective() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("haha");
        user.setPsw("pppppp");
        this.userMapper.insertSelective(user);
    }

    @Test
    public void selectByExample() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}