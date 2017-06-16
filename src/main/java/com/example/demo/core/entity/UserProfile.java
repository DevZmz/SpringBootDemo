package com.example.demo.core.entity;

/**
 * Created by zhangmz on 2017/6/14.
 */
public class UserProfile {
    private long id;
    private String content;

    public UserProfile(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
