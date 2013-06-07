package com.zt.example.service.impl;


import com.zt.example.domain.user.User;
import com.zt.example.manager.user.UserManager;
import com.zt.example.service.BaseService;
import com.zt.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
@Service
public class UserServiceImpl  extends BaseService implements UserService {

    @Resource
    private UserManager userManager ;

    public void insertUser(User user,String SQ_ID) {
        userManager.insertUser(user);
        log.info("add user sucess!");
    }

    public List<User> queryAll(User user){
          return userManager.queryAll(user);
     }
}
