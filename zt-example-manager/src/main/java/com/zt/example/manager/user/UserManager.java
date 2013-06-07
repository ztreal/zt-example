package com.zt.example.manager.user;

import com.zt.example.domain.user.User;

import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:39
 */
public interface UserManager  {


    public void insertUser(User user);

    public List<User> queryAll(User user);
}
