package dao;

import com.mongodb.Mongo;
import com.zt.todo.log.UserLog;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.net.UnknownHostException;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by IntelliJ IDEA.
 * User: zhangtan
 * Date: 12-7-28
 * Time: 11：19
 */
public class MongoTest extends BaseTestCase {

     private  MongoTemplate mongoOps;

    @Test
    public void insertLog() throws UnknownHostException {

     mongoOps.insert(new UserLog("zt", "我今天吃饭了"));

     log.info(mongoOps.findOne(new Query(where("operater").is("zt")), UserLog.class));

     mongoOps.dropCollection("person");
    }

    public MongoTemplate getMongoOps() {
        return mongoOps;
    }

    public void setMongoOps(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }
}
