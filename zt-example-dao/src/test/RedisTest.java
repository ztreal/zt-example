//package dao;
//
//import redis.clients.jedis.Jedis;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created with IntelliJ IDEA.
// * User: zhangtan
// * Date: 12-8-2
// * Time: 上午12:06
// * To change this template use File | Settings | File Templates.
// */
//public class RedisTest {
//    public static void main(String[] args) {
//              Jedis jedis = new Jedis("10.211.55.10",6379);
//               //String
//               jedis.set("kid", "Hello World!");
//               String value = jedis.get("key");
//               System.out.println(value);
//
//               //List
//               System.out.println("==List==");
//               jedis.rpush("messages", "Hello how are you?");
//               jedis.rpush("messages", "Fine thanks. I'm having fun with redis.");
//               jedis.rpush("messages", "I should look into this NOSQL thing ASAP");
//               List<String> values = jedis.lrange("messages", 0, -1);
//               System.out.println(values);
//
//               //Set
//               System.out.println("==Set==");
//               jedis.sadd("myset", "1");
//               jedis.sadd("myset", "2");
//               jedis.sadd("myset", "3");
//               jedis.sadd("myset", "4");
//               Set<String> setValues = jedis.smembers("myset");
//               System.out.println(setValues);
//
//               //Sorted Set
//               jedis.zadd("hackers", 1940, "Alan Kay");
//               jedis.zadd("hackers", 1953, "Richard Stallman");
//               jedis.zadd("hackers", 1965, "Yukihiro Matsumoto");
//               jedis.zadd("hackers", 1916, "Claude Shannon");
//               jedis.zadd("hackers", 1969, "Linus Torvalds");
//               jedis.zadd("hackers", 1912, "Alan Turing");
//               setValues = jedis.zrange("hackers", 0, -1);
//               System.out.println(setValues);
//
//               //Hash
//               System.out.println("==Hash==");
//               Map<String, String> pairs = new HashMap<String, String>();
//               pairs.put("name", "Akshi");
//               pairs.put("age", "2");
//               pairs.put("sex", "Female");
//               jedis.hmset("kid", pairs);
//               values = jedis.hmget("kid", new String[]{"name", "age", "sex"});
//               System.out.println(values);
//
//               setValues = jedis.hkeys("kid");
//               System.out.println(setValues);
//               values = jedis.hvals("kid");
//               System.out.println(values);
//               pairs = jedis.hgetAll("kid");
//               System.out.println(pairs);
//    }
//}
