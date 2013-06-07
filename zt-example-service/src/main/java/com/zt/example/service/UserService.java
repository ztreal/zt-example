package com.zt.example.service;

import com.zt.example.domain.user.User;

import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
public interface UserService {

    public void insertUser(User user,String SQ_ID);

    public List<User> queryAll(User user);
}
