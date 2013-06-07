package com.zt.example.manager.user.impl;

import com.zt.example.dao.user.UserDao;
import com.zt.example.domain.user.User;
import com.zt.example.manager.BaseManager;
import com.zt.example.manager.user.UserManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:41
 */
@Service
public class UserManagerImpl extends BaseManager implements UserManager {

    @Resource
    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);
    }


    public List<User> queryAll(User user){
          return userDao.queryAll(user);
       }

}
