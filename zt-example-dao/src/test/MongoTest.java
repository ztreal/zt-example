//package dao;
//
//import com.mongodb.DBCollection;
//import com.mongodb.WriteResult;
//import org.junit.Test;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//
//import java.net.UnknownHostException;
//
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//
///**
// * Created by IntelliJ IDEA.
// * User: zhangtan
// * Date: 12-7-28
// * Time: 11：19
// */
//public class MongoTest extends BaseTestCase {
//
//    private MongoTemplate mongoOps;
//
//    @Test
//    public void insertLog() throws UnknownHostException {
//        UserLog userLog = new UserLog("zt", "吃饭");
////        log.error("1");
//        mongoOps.insert(new UserLog("zt", "我今天吃饭了"));
//
//
//
////     mongoOps.dropCollection("person");
//
//
//        //save
//        mongoOps.save(userLog,"userLog");
//
//        //find
//        UserLog savedLog =  mongoOps.findOne(new Query(where("operater").is("zt")), UserLog.class);
//
//        log.error(savedLog);
//        System.out.println("savedLog : " + savedLog);
//
//        //update
//        WriteResult updateResult =  mongoOps.updateFirst(new Query(where("operater").is("zt")),
//                Update.update("operater", "qs"), UserLog.class);
//
//
//        System.out.println("updateResult : " + updateResult.getN());
//
//        //delete
//        mongoOps.remove(new Query(where("operater").is("zt")),"userLog");
//
//        //List
//        DBCollection dBCollection = mongoOps.getCollection("userLog");
//
//        System.out.println("Number of user = " + dBCollection.getCount());
//    }
//
//
//    public MongoTemplate getMongoOps() {
//        return mongoOps;
//    }
//
//    public void setMongoOps(MongoTemplate mongoOps) {
//        this.mongoOps = mongoOps;
//    }
//}
