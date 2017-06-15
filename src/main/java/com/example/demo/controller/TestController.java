package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhangmz on 2017/6/14.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    public static final String template = "hello world";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/hello")
    public User hello(){
        return new User(counter.incrementAndGet(),template);
    }
}
