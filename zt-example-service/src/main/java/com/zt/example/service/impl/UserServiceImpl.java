package com.zt.example.service.impl;


import com.zt.example.domain.user.User;
import com.zt.example.manager.user.UserManager;
import com.zt.example.service.BaseService;
import com.zt.example.service.UserService;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
public class UserServiceImpl  extends BaseService implements UserService {

    private UserManager userManager ;

    public void insertUser(User user,String SQ_ID) {
        userManager.insertUser(user);
        log.info("add user sucess!");
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
