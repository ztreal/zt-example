package com.zt.example.util.other;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-5-23
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class Lottery {

    /**
     * 用户抽奖
     */
    public static int lottery() {
        SecureRandom random = new SecureRandom();
        int b = random.nextInt(100000);
        System.out.println(b);
        return b;
    }


    /**
     * 用户抽奖
     */
    public static int lottery2() {
        Random random = new Random();
        int b = random.nextInt(100000);
        System.out.println(b);
        return b;
    }

    public static void main(String args[]) {
        int d = 0;
        Map a = new HashMap<Integer, Integer>();
        for (int f = 1; f < 100000; f++) {
            int ff = lottery2();
            if (a.get(ff) != null) {
                d++;
            }else{
                a.put(ff, ff);
            }
        }
        System.out.println("重复次数为"+d);
    }
}
