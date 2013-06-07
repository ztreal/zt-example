package com.zt.example.web.dao;

import com.zt.example.dao.user.UserDao;
import com.zt.example.domain.user.User;
import com.zt.example.web.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: zhangtan
 * Date: 13-6-7
 * Time: 上午9:52
 */
public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void testqueryAll(){
        User user = new User();
        userDao.queryAll(user);
    }


}
