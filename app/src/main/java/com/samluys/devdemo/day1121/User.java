package com.samluys.devdemo.day1121;

import java.io.Serializable;

/**
 * @author luys
 * @describe
 * @date 2018/11/22
 * @email samluys@foxmail.com
 */
public class User implements Serializable {

    private static final long serialVersionUID = 5263782362683L;

    public int userId;

    public String username;


    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}
