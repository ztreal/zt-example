package com.zt.example.dao.user.impl;

import com.zt.example.dao.BaseDao;
import com.zt.example.dao.user.UserDao;
import com.zt.example.user.User;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:27
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    private MongoTemplate mongoOps;

    public void insertUser(User user) {
        mongoOps.insert(user);
    }

    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
