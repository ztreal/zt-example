//package com.zt.example.web.dao;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.Mongo;
//
//public class T {
//    public static void main(String[] args) throws Exception {
//        Mongo m = new Mongo("10.211.55.10", 27017);
//        DB d = m.getDB("test");
//        DBCollection col = d.getCollection("userLog");
//        BasicDBObject o = new BasicDBObject();
//        col.findOne(o);
//    }
//}