//package dao;
//
//import org.bson.BSONObject;
//import org.bson.BasicBSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// * User: zhangtan
// * Date: 12-8-10
// * Time: 上午9:19
// * To change this template use File | Settings | File Templates.
// */
//public class BsonTest {
//    public static void main(String args[]){
//        BSONObject MessageObj = new BasicBSONObject();
//            MessageObj.put("1","1");
//            MessageObj.put("id",1);
//            MessageObj.put("seq",1);
//            MessageObj.put("source",3);
//            MessageObj.put("target",4);
//            MessageObj.put("sname","node1");
//            MessageObj.put("tname","node2");
//            MessageObj.put("pks",5);
//            MessageObj.put("pkseq",6);
//            MessageObj.put("stype",1);
//            MessageObj.put("serializertype",1);
//            MessageObj.put("serializeclassname","MessageObject");
//            MessageObj.put("fcompressed",true);
//            MessageObj.put("fnull",false);
//            List<BSONObject> datas = new ArrayList<BSONObject>();
//            for(
//            int i = 0;
//            i<10000;i++)
//
//            {
//                BSONObject mes = new BasicBSONObject();
//                mes.put(String.valueOf(i), "jukyoc");
//                mes.put(String.valueOf(Math.random()), "oldman");
//                mes.put(String.valueOf(Math.random()), "testjukyoc");
//                mes.put(String.valueOf(i), 1);
//                mes.put(String.valueOf(i), 1234565);
//                mes.put(String.valueOf(i), new byte[]{1, 2, 3, 4});
//                datas.add(mes);
//            }
//
//            MessageObj.put("data",datas);
//
//
//
//        System.out.println(MessageObj);
//    }
//
//}
