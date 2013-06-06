package com.zt.example.manager.user.impl;

import com.zt.example.dao.user.UserDao;
import com.zt.example.manager.BaseManager;
import com.zt.example.manager.user.UserManager;
import com.zt.example.domain.user.User;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:41
 */
public class UserManagerImpl extends BaseManager implements UserManager {

    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
